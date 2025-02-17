package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.User;
import kh.edu.react.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    /*
    Map< KEY, Value > = java에서 key-value(키-값) 쌍을 저장하는 자료구조
    Map<String, Object> = String 문자열 타입의 key를 사용하고, object 타입의 value 를 저장할 수 있기 때문에
                                다양한 데이터 타입을 한 번에 저장할 때 유용
                                Value 값에 Onject로 작성하는 것은
                                어떤 타입이든 저장 가능 (Integer, String, List, User, 개발자가 만든 객체)
                                예) "인사말" - [
                                                    {"1번" - "안녕하세요."},
                                                    {"2번" - "안녕히가세요."},
                                                    ("3번" - "반갑습니다."}]
                                    Object 를 사용하면 아래처럼 단일 문자만 저장하는 것이 아니라
                                    인사말 키에서 장르별로 값을 목록화하여 저장할 수 있음
                                    데이터를 가져올 때 에러 최소화
    Map<String, String> = 문자열 - 문자열 만 저장 가능
                          예) "인사말" = "안녕하세요." 와 같은 형태만 가능
    Map<String, Integer> = 문자열 - 숫자 만 저장 가능
                           예) "인증번호" - 123456
    Map<Integer, Integer> = 숫자 - 숫자만 가능
                            예) 1 - 56789
    */
    @Override
    public Map<String, Object> loginUser(String userId, String password) {
        User loggedInUser = userMapper.loginUser(userId, password);
        Map<String, Object> result = new HashMap<String, Object>();

        if (loggedInUser != null) {
            result.put("status", "success");
            result.put("user", loggedInUser);
            result.put("redirect", "/");
        }else {
            result.put("status", "fail");
            result.put("message", "아이디 또는 비밀번호가 올바르지 않습니다.");
        }
        return result;
    }
}
