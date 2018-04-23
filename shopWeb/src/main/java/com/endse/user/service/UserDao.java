package com.endse.user.service;

import com.endse.user.entity.User;
import org.hibernate.Session;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by chensr on 2018/4/21.
 */
@Component
@Repository("userDao")
public class UserDao {


    public void save(User user){

        System.out.println("保存了");
    }


}
