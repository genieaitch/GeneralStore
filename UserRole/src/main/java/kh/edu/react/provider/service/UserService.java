package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.User;

import java.util.List;
import java.util.Map;

// 서비스 목록
public interface UserService {
    // 유저 로그인
    User getUserById(String userId);

    // 로그인한 유저 정보 가져오기
    Map<String, Object> loginUser(String userId, String userPassword);

    // 유저 이름으로 조회되는 유저 검색하기
    List<User> findUserByName(String userName);
}
