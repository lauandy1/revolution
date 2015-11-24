package org.autumn.revolution.web.controller;

import org.autumn.revolution.web.entity.User;
import org.autumn.revolution.web.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangzhichao on 15/11/23.
 */
@RestController
@RequestMapping(value="/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUserList(){

        List<User> list = new ArrayList<>();
        User user1 = new User();
        user1.setId("1001");
        user1.setUsername("yang");
        list.add(user1);
        User user2 = new User();
        user2.setId("1002");
        user2.setUsername("huang");
        list.add(user2);
        return list;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void insertUser(){
        User user = new User();
        user.setId("1001");
        user.setUsername("yang");
        userService.insertUser(user);
    }
}
