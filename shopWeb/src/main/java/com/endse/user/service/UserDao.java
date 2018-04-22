package com.endse.user.service;

import com.endse.user.entity.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by chensr on 2018/4/21.
 */
@Repository("userDao")
public class UserDao extends HibernateDaoSupport{
    public void save(User user){
        this.getHibernateTemplate().save(user);
    }
}
