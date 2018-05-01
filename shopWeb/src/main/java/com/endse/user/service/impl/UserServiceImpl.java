package com.endse.user.service.impl;

import com.endse.common.repository.dao.CommonDao;
import com.endse.user.entity.User;
import com.endse.user.service.UserService;
import org.javasimon.aop.Monitored;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * Created by chensr on 2018/4/20.
 */
@Component
@Transactional(readOnly = true)
@Monitored
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
   public CommonDao commonDaoImpl;

    @Transactional
    public void say(String name, String say)throws Exception {

            System.out.println(name+":"+say);
            User user = new User();
            user.setUserName("chensr");
            user.setUserPw("b");
            user.setUserAddress("2");
            user.setUserAtime(12345);
            user.setUserEmail("3234");
            user.setUserIp("110");
            user.setUserMoney(new BigDecimal("123"));
            user.setUserLtime(12345);
            user.setUserPhone("110");
            user.setUserPoint(1);
            user.setUserPointAll(1234);
            user.setUserQq("1234");
            user.setUserTname("chensr");
            user.setUserTel("1234");
            commonDaoImpl.save(user);
            System.out.println(user);
            User user1 = commonDaoImpl.load(User.class,23L);
            commonDaoImpl.delete(user1);



    }
}
