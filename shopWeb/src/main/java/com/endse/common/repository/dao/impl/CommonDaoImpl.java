package com.endse.common.repository.dao.impl;

import com.endse.common.repository.dao.CommonDao;
import com.endse.common.tool.MapUtils;
import com.endse.common.tool.SqlUtil;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/25.
 */
@Component("commonDaoImpl")
public class CommonDaoImpl implements CommonDao {

    private JpaTransactionManager transactionManager;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * 保存或更新
     */
    public <T> T save(T entity) {
        Session session = getHibernateSession(getEntityManager());
        session.saveOrUpdate(entity);
        return entity;
    }

    /**
     * 主方法无事务模式时，save方法满足不了需求，故新加
     */
    @Transactional
    public <T> T save4NoTrans(T entity) {
        Session session = getHibernateSession(getEntityManager());
        session.saveOrUpdate(entity);
        return entity;
    }

    /**
     * 删除
     *
     * @param <T>
     */
    public <T> void delete(T entity){
        int b=1/0;
        Session session = getHibernateSession(getEntityManager());
        session.delete(entity);
    }

    /**
     * 非延迟加载
     */
    @Transactional(readOnly = true)
    public <T> T get(Class<T> entityClazz, Long id) {
        Session session = getHibernateSession(getEntityManager());
        Object entity = null;
        try {
            entity = session.get(entityClazz, id);
            if (entity == null) {
                return null;
            }
        } catch (Exception ex) {
        } finally {
            EntityManagerFactoryUtils.closeEntityManager(entityManager);
        }
        return (T) entity;
    }

    /**
     * 延迟加载
     */
    @Transactional(readOnly = true)
    public <T> T load(Class<T> entityClazz, Long id) {
        Session session = getHibernateSession(getEntityManager());
        Object entity = null;
        try {
            entity = session.load(entityClazz, id);
            Hibernate.initialize(entity);
            if (entity == null) {
                return null;
            }
        } catch (Exception ex) {
        } finally {
        }
        return (T) entity;
    }

    @Override
    @Transactional(readOnly = true)
    public <T> T load(Class<T> entityClazz, String id) {
        Session session = getHibernateSession(getEntityManager());
        Object entity = null;
        try {
            entity = session.load(entityClazz, id);
            Hibernate.initialize(entity);

            if (entity == null) {
                return null;
            }
        } catch (Exception ex) {
        } finally {
        }
        return (T) entity;
    }


    @Override
    @Transactional(readOnly = true)
    public <T> List<T> find(String hql, Map<String, Object> param) {
        Session session = getHibernateSession(getEntityManager());
        Query<T> query = session.createQuery(hql);
        for (String s : param.keySet()) {
            query.setParameter(s, param.get(s));
        }
        List<T> list = query.getResultList();
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public <T> List<T> find(String hql, Map<String, Object> param, int maxResult) {
        Session session = getHibernateSession(getEntityManager());
        Query<T> query = session.createQuery(hql);
        for (String s : param.keySet()) {
            query.setParameter(s, param.get(s));
        }
        query.setMaxResults(maxResult);
        List<T> list = query.getResultList();
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public List findList(String hql, Map<String, Object> param) {
        Session session = getHibernateSession(getEntityManager());
        Query query = session.createQuery(hql);
        if (MapUtils.isNotEmpty(param)) {
            for (String s : param.keySet()) {
                query.setParameter(s, param.get(s));
            }
        }
        List list = query.getResultList();
        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public <T> T findOne(String hql, Map<String, Object> param) {
        Session session = getHibernateSession(getEntityManager());
        Query<T> query = session.createQuery(hql);
        if (MapUtils.isNotEmpty(param)) {
            for (String s : param.keySet()) {
                query.setParameter(s, param.get(s));
            }
        }
        return query.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public List findByNative(String sql, Map<String, Object> param) {
        Session session = getHibernateSession(getEntityManager());
        Query query = session.createNativeQuery(sql);
        if (MapUtils.isNotEmpty(param)) {
            for (String s : param.keySet()) {
                query.setParameter(s, param.get(s));
            }
        }
        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Object findOneByNative(String sql, Map<String, Object> param) {
        Session session = getHibernateSession(getEntityManager());
        Query<Object> query = session.createNativeQuery(sql);
        for (String s : param.keySet()) {
            query.setParameter(s, param.get(s));
        }
        return query.getSingleResult();
    }

    @Override
    public int executeUpdate(String hql, Map<String, Object> param) {
        Session session = getHibernateSession(getEntityManager());
        Query query = session.createQuery(hql);
        for (String s : param.keySet()) {
            query.setParameter(s, param.get(s));
        }
        return query.executeUpdate();
    }

    @Override
    public int executeUpdateByNative(String sql, Map<String, Object> param) {
        Session session = getHibernateSession(getEntityManager());
        Query<?> query = session.createNativeQuery(sql);
        for (String s : param.keySet()) {
            query.setParameter(s, param.get(s));
        }
        return query.executeUpdate();
    }



    public <T> T mergeSave(T entity) {
        Session session = getHibernateSession(getEntityManager());
        entity = (T) session.merge(entity);
        session.saveOrUpdate(entity);
        return entity;
    }

    public Object merge(Object paramObject) {
        return getHibernateSession().merge(paramObject);
    }

    public Object merge(String paramString, Object paramObject) {
        return getHibernateSession().merge(paramString, paramObject);
    }

    @Override
    public Connection getConnection() {
        try {
            return SessionFactoryUtils.getDataSource(getHibernateSession().getSessionFactory()).getConnection();
        } catch (SQLException e) {
        }
        return null;
    }

    public int executeHQL(String paramString, Map<String, Object> paramMap) {
        Query localQuery = getHibernateSession(getEntityManager()).createQuery(paramString);
        Iterator localIterator = paramMap.keySet().iterator();
        while (localIterator.hasNext()) {
            String str = (String) localIterator.next();
            applyNamedParameterToQuery(localQuery, str, paramMap.get(str));
        }
        int i = localQuery.executeUpdate();
        return i;
    }

    protected void applyNamedParameterToQuery(Query paramQuery, String paramString, Object paramObject)
            throws HibernateException {
        if (paramObject instanceof Collection)
            paramQuery.setParameterList(paramString, (Collection) paramObject);
        else if (paramObject instanceof Object[])
            paramQuery.setParameterList(paramString, (Object[]) paramObject);
        else
            paramQuery.setParameter(paramString, paramObject);
    }

    public StringBuilder generatePagingSql(int pageStart, int pageSize, StringBuilder sql) {
        return sql.append(" limit " + (pageStart - 1) + "," + pageSize);
    }

    public StringBuilder generatePagingSql(int pageStart, int pageSize, StringBuilder sql, StringBuilder orderBySql) {
        return new StringBuilder(
                SqlUtil.buildPageSearchSql(sql.toString(), pageStart, pageSize, orderBySql.toString()));
    }

    public void setTransactionManager(JpaTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private EntityManager getEntityManager() {
        if (entityManager != null) {
            return entityManager;
        }
        return this.transactionManager.getEntityManagerFactory().createEntityManager();
    }

    public Session getHibernateSession() {
        return getHibernateSession(getEntityManager());
    }

    private Session getHibernateSession(EntityManager em) {
        Session session = em.unwrap(org.hibernate.Session.class);
        return session;
    }

    public <T> void evict(T entity) {
        getHibernateTemplate().evict(entity);
    }

    public HibernateTemplate getHibernateTemplate() {
        return new HibernateTemplate(getHibernateSession(getEntityManager()).getSessionFactory());
    }

    public void flush() {
        getHibernateSession().flush();
    }

    public void clear() {
        getHibernateSession().clear();
    }
}
