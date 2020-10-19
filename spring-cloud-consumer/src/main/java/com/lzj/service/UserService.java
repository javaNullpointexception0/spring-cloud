package com.lzj.service;

import com.lzj.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//name为serviceId，fallback指定降级服务
@FeignClient(name = "provider-user", fallback = UserServiceFallback.class)
public interface UserService {

    @RequestMapping(value="/user/list", method = RequestMethod.GET)
    public List<User> list();
}
