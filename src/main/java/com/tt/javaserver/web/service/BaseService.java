package com.tt.javaserver.web.service;

import com.tt.javaserver.web.model.SimpleResult;

/**
 * Created by GCL on 17/4/15.
 */
public interface BaseService<T> {


    SimpleResult deleteByStr(String code);

    SimpleResult deleteByInt(int id);


    //添加对象
    SimpleResult insert(T entity);

    //修改对象
    SimpleResult update(T entity);

    //查询对象
    SimpleResult select(T entity);


}
