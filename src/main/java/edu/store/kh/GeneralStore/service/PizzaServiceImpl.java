package edu.store.kh.GeneralStore.service;

import edu.store.kh.GeneralStore.dto.Pizza;
import edu.store.kh.GeneralStore.mapper.PizzaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PizzaServiceImpl implements PizzaService {
    // 직접적으로 경로를 작성할 경우 파일 위치 노출에 대한 위험이 있기 때문에 properties 작성 후 불러오기
    @Value("${upload-img}") //파일이름.properties 에서 작성한 변수이름을 가져와서 변수 이름 내 작성된 경로 사용
    private String uploadImg;

    @Autowired
    PizzaMapper pizzaMapper; //서비스 기능에서 필요한 sql구문 mapper 가져와 사용


    @Override
    public List<Pizza> selectAll() {
        // 피자 메뉴를 모두 목록 형태로 가져오기
        return pizzaMapper.selectAll();
    }

    @Override
    public Pizza selectById(int id) {
        // 선택한 id 값으로 피자 메뉴 1가지를 선택해서 상세 조회
        return pizzaMapper.selectById(id);
    }

    // insert 기존에 저장된 id값이 없기 때문에 매개변수 작성 X
    @Override
    public int insertPizza(String name, int price, String description, MultipartFile imagePath) {
        // insert → System
        // System.currentTimeMillis() 를 이용해서 이미지 저장 코드 작성
        // 피자메뉴에 피자를 추가할 경우 이미지를 저장할 경로를 설정하여 추가
        // imagePath 앞에 System.currentTimeMillis() 현재 시간 추가한 다음

        String uniqueFileName = System.currentTimeMillis() + UUID.randomUUID().toString();

        try {
            File file = new File(uploadImg + uniqueFileName);
            imagePath.transferTo(file);
        } catch (IOException e) {
            System.out.println("이미지를 저장할 수 없습니다.");
            e.printStackTrace(); //빨간글씨로 에러를 볼 것인가
            System.out.println(e.getMessage()); //검정글씨로 에러를 볼 것인가
        }
        // pizza 변수에 저장
        Pizza pizza = new Pizza();
        pizza.setName(name);
        pizza.setPrice(price);
        pizza.setDescription(description);
        pizza.setImagePath("/uploaded/" + uniqueFileName);
        return pizzaMapper.insertPizza(pizza);
    }

    @Override
    public int updatePizza(int id, String name, int price, String description, MultipartFile imagePath) {
        // 피자 메뉴에 피자를 추가할 경우 이미지 저장할 경로를 설정하여 추가
        // 기존에 저장된 이미지 삭제 또는 보존

        // 이미지를 저장하기 전에 사용자1, 사용자2, 사용자3, ... 가 저장하는 이미지 파일명이 일치하는 경우
        // 마지막에 이미지를 저장하는 사용자의 파일로 모두 덮어쓰기가 되기 때문에
        // 각 회사만의 방법으로 이미지 덮어쓰기가 되지 않도록 분류
        // 1. UUID = 랜덤으로 이름 작성 2. System.currentTimeMillis() = 현재시간 추가 메서드 사용
        // Universally Unique IDentifier 범용 고유 식별자
        // UUID.randomUUID() = 거의 충볼 없는 고유한 식별자 만듬
        // 만들어진 식별자 128비트(16바이트) 컴퓨터로 만들어진 값을 사람이 읽을 수 있는 문자열(String) 형태로 변환
        // UUID 의 경우 기존에 있던 파일이름을 36자리로 변환해서 사용
        String uuid = UUID.randomUUID().toString(); // 8-4-4-4-12 총 36자리 문자열 형식 하이픈(-) 포함

        // 1-1. 확장자명을 고객이 작성한 확장자명으로 가져오고 싶을 경우
        String originalFilename = imagePath.getOriginalFilename(); //사용자가 작성한 파일이름.확장명 가져오기
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".")); // . 뒤에 작성된 확장명 가져오기

        // 이미지를 어디에 저장?
        // File → transferTo
        try { // 일단은 사용자 컴퓨터에서 이미지 데이터를 가져와 우리 회사 컴퓨터에 저장해보자
            //File file = new File(imagePath.getOriginalFilename()); // 프로젝트 폴더 내 클라이언트에서 가져온 파일이름 저장
            // File file = new File("어디에 저장할 것이고 어떤 이름으로 저장할 것인가");
            File file = new File(uploadImg + "/" + uuid + fileExtension); // fileExtension = 사용자에게 가져온 확장명 파일 유형

            // 사용자에게서 가져온 파일을. 저장하겠다(회사컴퓨터.uuid로 만든 랜덤이름으로)
            imagePath.transferTo(file);
            System.out.println("이미지가 성공적으로 저장되었습니다.");
        } catch (IOException e) { // 그런데 문제가 생기면 문제가 생겼다 사용자에게 알리고 조취를 취하자 → 일시중지, 작업취소
            System.out.println("이미지 저장 담당자님 파일 저장에 문제가 생겼습니다.");
        }

        // 프론트엔드 → 컨트롤러 전달받은 데이터 중에서 이미지를 경로만 String으로 DB에 저장한 후
        // pizza 라는 변수이름으로 sql 전달
        Pizza pizza = new Pizza();
        pizza.setId(id);
        pizza.setName(name);
        pizza.setPrice(price);
        pizza.setDescription(description);

        //DB에 경로를 추가할 때는 WebConfig에 작성한 fake 경로를 파일명 아펭 작성
        //예를 들어 WebConfig 에서 C://pizza-image/ 경로를 /upload/라는 경로로 읽도록 설정
        //DB에           가짜이미지경로 + 파일명 + 확장명
        pizza.setImagePath("/uploaded/" + uuid + fileExtension);
        //pizza.setImagePath(imagePath.getOriginalFilename()); //imagePath.getOriginalFilename() → uuid 로 작성된 파일명 설정
        return pizzaMapper.updatePizza(pizza);
    }

    @Override
    public int deletePizza(int id) {
        // 특정 아이디로 저장된 피자 메뉴 삭제
        return pizzaMapper.deletePizza(id);
    }
}