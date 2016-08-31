package org.autumn.revolution.web.service;

import org.autumn.revolution.web.dao.UserDao;
import org.autumn.revolution.web.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by yangzhichao on 15/11/24.
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserDao userDao;

    public void insertUser(User user){
        userDao.insertUser(user);

    }

    @Transactional
    public void testTransaction(){
        LOGGER.info("test transaction");
    }

}
