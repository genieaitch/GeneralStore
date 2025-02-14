package edu.store.kh.GeneralStore.service;

import edu.store.kh.GeneralStore.dto.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

public interface UserService {
    User findUserId(@Param("userId") String userId);

    User loginUser(@Param("userId") String userId,
                     @Param("password") String password);
}
