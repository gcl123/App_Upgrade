package com.tt.javaserver.web.dao;

import com.tt.javaserver.web.vo.Page;
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
    int deleteByInt(int id);

    int deleteByStr(String str);

    int delete(T entity);

    //    更新对象
    int update(T entity);

    //    模糊查询对象个数
    int selectCount(T entity);

    //    通过关键字迷糊查询数据列表
    List<T> selectList(T entity);

    T selectById(int id);


    //    查询记录个数
    int selectRecord(T entity);

    //    查询单个对象
    List<T> select();

    List<T> selectPageListUseDyc(Page<T> page);

    Integer selectPageCountUseDyc(Page<T> page);
}

