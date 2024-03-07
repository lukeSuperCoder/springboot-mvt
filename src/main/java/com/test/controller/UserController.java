package com.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.test.pojo.MVTReq;
import com.test.pojo.User;
import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;


    @GetMapping("/getUserList")
    @ResponseBody
    public IPage<User> getUserList(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer size) {
        Page<User> page = new Page<>(current, size);
        return userService.findUserList(page);
    }
    @PostMapping("/getUser")
    @ResponseBody
    public List<User> findUserList(@RequestBody User user)  throws JsonProcessingException {
        List<User> userResult = userService.findUserById(user);
        ObjectMapper mapper = new ObjectMapper();

        // 将List<User>转换为JSON格式的字符串，这个字符串在发送到前端时会被浏览器自动解析为JSON对象数组
        String jsonResult = mapper.writeValueAsString(user);
        System.out.println(jsonResult);
        return userResult;
    }

    @PostMapping("/createUser")
    @ResponseBody
    public Map<String, Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public Map<String, Object> updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @PostMapping("/deleteUser")
    @ResponseBody
    public Map<String, Object> deleteUser(@RequestBody User user) {
        return userService.deleteUser(user);
    }

    @GetMapping(value = "/getMvtByArea", produces = "application/x-protobuf")
    public Object getMvtByArea(MVTReq req) {
        return userService.getMvtByArea(req);
    }
}
