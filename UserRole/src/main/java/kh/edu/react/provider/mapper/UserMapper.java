package kh.edu.react.provider.mapper;

import kh.edu.react.provider.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 유저 로그인
    User getUserById(String userId);

    // 로그인한 유저 정보 가져오기
    User loginUser(String userId, String userPassword);

    // 유저 이름으로 조회되는 유저 검색하기
    List<User> findUserByName(String userName);
}
