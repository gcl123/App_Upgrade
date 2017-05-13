package com.tt.javaserver.web.service;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.vo.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
public interface BaseService<T> {


    int deleteByStr(String code);

    int deleteByInt(int id);

    Map selectPageUseDyc(Page<T> page);


    //添加对象
    int insert(T entity);

    //修改对象
    int update(T entity);


    //查询对象
    SimpleResult<Map> select(T entity);

    //通过主键查找对象
    T select(int id);


    //动态查询
    int selectTotal(T entity);

    List<T> selectList(T entity);
}
