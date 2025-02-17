package edu.store.kh.GeneralStore.service;

import edu.store.kh.GeneralStore.dto.User;
import edu.store.kh.GeneralStore.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserId(String userId) {
        return userMapper.findUserId(userId);
    }

    @Override
    public User loginUser(String userId, String password) {
        return userMapper.loginUserId(userId, password);
    }
}
