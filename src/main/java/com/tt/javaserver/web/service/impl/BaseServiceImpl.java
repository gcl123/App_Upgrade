package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.dao.*;
import com.tt.javaserver.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */

public class BaseServiceImpl<T> implements BaseService<T> {

    protected BaseMapper<T> baseMapper;

    @Autowired
    protected ActionMapper actionMapper;

    @Autowired
    protected AppFilesMapper appFilesMapper;

    @Autowired
    protected AppMapper appMapper;

    @Autowired
    protected AppVersionMapper appVersion;

    @Autowired
    protected FileMapper fileMapper;

    @Autowired
    protected CompanyMapper companyMapper;


    @Override
    public int insert(T entity) throws Exception {
        return baseMapper.insert(entity);
    }

    @Override
    public int update(T entity) {
        return baseMapper.update(entity);
    }

    @Override
    public int delete(int id) throws Exception {
        System.out.println("service+=======");
        return baseMapper.delete(id);
    }


    @Override
    public int deleteList(String[] pks) throws Exception {
        return baseMapper.deleteList(pks);
    }

    @Override
    public T select(T entity) {
        return (T) baseMapper.select(entity);
    }

    @Override
    public List<T> selectList(T entity) {
        return baseMapper.selectListUseDyc(entity);
    }

    @Override
    public int selectCount(T entity) {
        System.out.println("base............." + entity);
        return baseMapper.selectCountUserDyc(entity);
    }

    @Override
    public int getID(T entity) throws Exception {
        return baseMapper.selectID(entity);
    }
}
