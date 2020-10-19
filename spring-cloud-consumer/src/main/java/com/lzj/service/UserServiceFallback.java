package com.lzj.service;

import com.lzj.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceFallback implements UserService {

    @Override
    public List<User> list() {
        User user = new User();
        user.setUserName("服务降级");
        user.setUserNo(-1L);
        return Arrays.asList(user);
    }
}
