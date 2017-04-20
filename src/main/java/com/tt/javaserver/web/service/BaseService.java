package com.tt.javaserver.web.service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
public interface BaseService<T> {

    //添加单个对象
    int insert(T entity) throws Exception;

    //修改单个对象
    int update(T entity);

    //删除单个对象
    int delete(int id) throws Exception;

    //通过主键（数组）批量删除数据
    int deleteList(String[] pks) throws Exception;


    //查询单个对象
    T select(T entity);

    //    迷糊查询多个查询对象
    List<T> selectList(T entity);

    //    查询对象个数
    int selectCount(T entity);

    int getID(T entity);
}
