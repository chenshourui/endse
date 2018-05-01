package com.endse.common.repository.dao.impl;

import com.endse.common.repository.dao.CommonDao;
import org.hibernate.Session;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Administrator on 2018/4/25.
 */
@Component
public class CommonDaoImpl implements CommonDao {
    private JpaTransactionManager transactionManager;
    @PersistenceContext
    private EntityManager entityManager;

    public  <T> T save(T entity) {
        Session session = getHibernateSession(getEntityManager());
        session.saveOrUpdate(entity);

        System.out.println("保存了");
        return entity;
    }


    private Session getHibernateSession(EntityManager em) {
        Session session = em.unwrap(org.hibernate.Session.class);
        return session;
    }

    private EntityManager getEntityManager() {
        if (entityManager != null) {
            return entityManager;
        }
        return this.transactionManager.getEntityManagerFactory().createEntityManager();
    }

    public void setTransactionManager(JpaTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
