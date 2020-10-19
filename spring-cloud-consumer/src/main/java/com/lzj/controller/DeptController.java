package com.lzj.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzj.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("list")
    public List<Dept> list() {
        try {
            URI uri = UriComponentsBuilder.fromUriString("http://provider-dept/dept/list").build().toUri();
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
            String responseData = responseEntity.getBody();
            List<Dept> deptList = objectMapper.readValue(responseData, new TypeReference<List<Dept>>() {});
            return deptList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<Dept>();
    }
}
