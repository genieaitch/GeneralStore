package edu.store.kh.GeneralStore.service;

import edu.store.kh.GeneralStore.dto.Pizza;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// 서비스 interface 는
// 어떤 자료형 / 어떤 매개변수를 이용해서
// 메서드 목록이 작성되어 있는지에 대한 목록


public interface PizzaService {
    // 피자 메뉴 모두 조회
    public List<Pizza> selectAll();

    // 피자 상세 조회
    public Pizza selectById(int id);

    // 피자 메뉴 저장 - 자료형  void or int
    public int insertPizza(String name, int price, String description, MultipartFile imagePath);

    // 피자 메뉴 수정 - 자료형  void or int
    public int updatePizza(int id, String name, int price, String description, MultipartFile imagePath);

    // 피자 메뉴 삭제 - 자료형  void or int
    public int deletePizza(int id);
}