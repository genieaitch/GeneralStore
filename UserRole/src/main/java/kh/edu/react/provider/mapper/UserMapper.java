package kh.edu.react.provider.mapper;

import kh.edu.react.provider.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 유저 로그인
    User getUserById(String userId);

    // 로그인한 유저 정보 가져오기
    User loginUser(String userId, String password);
}
