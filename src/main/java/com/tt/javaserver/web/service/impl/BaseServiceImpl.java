package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.dao.*;
import com.tt.javaserver.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */

@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected BaseMapper<T> baseMapper;

    @Autowired
    protected ActionMapper actionMapper;

    @Autowired
    protected AppFilesMapper appFilesMapper;

    @Autowired
    protected AppMapper appMapper;

    @Autowired
    protected AppVersionMapper appVersionMapper;

    @Autowired
    protected FileMapper fileMapper;

    @Autowired
    protected CompanyMapper companyMapper;


    @Override
    public int insert(T entity) throws Exception {
        System.out.println("base=======insert" + entity);
        return baseMapper.insert(entity);
    }

    @Override
    public int update(T entity) {
        System.out.println("update__baseServiceImpl======" + entity);
        return baseMapper.update(entity);
    }

    @Override
    public int delete(T entity) {
        return 0;
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
        System.out.println("baseServiceimple===selectList" + entity);

        return baseMapper.selectList(entity);
    }

    @Override
    public int selectCount(T entity) {
        System.out.println("baseServiceimple===selectcount" + entity);
        return baseMapper.selectCount(entity);
    }

    @Override
    public int getID(T entity) {
        return baseMapper.selectID(entity);
    }
}
