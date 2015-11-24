package org.autumn.revolution.web.service;

import org.autumn.revolution.web.dao.UserDao;
import org.autumn.revolution.web.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangzhichao on 15/11/24.
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public void insertUser(User user){
        userDao.insertUser(user);

    }

}
