package com.endse.common.repository.dao;

import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/25.
 */
public interface CommonDao {
    /**
     * 保存或更新
     */
     <T> T save(T entity);


    /**
     * 删除
     *
     * @param <T>
     */
    <T> void delete(T entity);

    /**
     * 非延迟加载
     */
    <T> T get(Class<T> entityClazz, Long id);

    /**
     * 延迟加载
     */
    <T> T load(Class<T> entityClazz, Long id);

    /**
     * 延迟加载
     */
    <T> T load(Class<T> entityClazz, String id);

    /**
     * HQL查询
     */
    <T> List<T> find(String hql, Map<String, Object> param);

    /**
     * HQL查询
     */
    public <T> List<T> find(String hql, Map<String, Object> param, int maxResult);

    /**
     * HQL查询
     */
    List findList(String hql, Map<String, Object> param);

    /**
     * HQL查询单个结果
     */
    <T> T findOne(String hql, Map<String, Object> param);

    /**
     * SQL查询
     */
    List findByNative(String sql, Map<String, Object> param);

    /**
     * SQL查询单个结果
     */
    Object findOneByNative(String sql, Map<String, Object> param);

    /**
     * 执行更新操作
     */
    int executeUpdate(String hql, Map<String, Object> param);

    /**
     * 执行更新操作
     */
    int executeUpdateByNative(String sql, Map<String, Object> param);

    Session getHibernateSession();

    Connection getConnection();

    public <T> void evict(T entity);

    public HibernateTemplate getHibernateTemplate();

    public void flush();

    public void clear();

    public <T> T mergeSave(T entity);

    public <T> T merge(T entity);

    public <T> T merge(String paramString, T entity);

    int executeHQL(String paramString, Map<String, Object> paramMap);

    public StringBuilder generatePagingSql(int pageStart, int pageSize, StringBuilder sql);

    public StringBuilder generatePagingSql(int pageStart, int pageSize, StringBuilder sql, StringBuilder orderBySql);

}
