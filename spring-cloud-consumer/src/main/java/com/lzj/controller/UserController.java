package com.lzj.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzj.entity.Dept;
import com.lzj.entity.User;
import com.lzj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public List<User> list() {
        try {
            return userService.list();
//            List<Dept> deptList = objectMapper.readValue(responseData, new TypeReference<List<Dept>>() {});
//            return deptList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<User>();
    }
}
