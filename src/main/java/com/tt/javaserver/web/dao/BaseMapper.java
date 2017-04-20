package com.tt.javaserver.web.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by GCL on 17/4/13.
 */

@Repository
public interface BaseMapper<T> {


    //    添加对象
    int insert(T entity);

    //    删除对象
    int delete(int id);

    //    更新对象
    int update(T entity);

    //    模糊查询对象个数
    int selectCount(T entity);

    //    通过关键字迷糊查询数据列表
    List<T> selectList(T entity);

    //   查询对象个数
    int selectVersionTotal(T entity);



    //    查询单个对象
    T select(T entity);

    //    通过主键（数组）批量删除数据
    int deleteList(String[] pks);

    //    查询ID
    int selectID(T entity);
}
