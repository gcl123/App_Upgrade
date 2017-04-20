package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.vo.App;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService {

    @Override
    public int insert(App entity) {
        return appMapper.insert(entity);
    }

    @Override
    public int update(App entity) {
        return appMapper.update(entity);
    }

    @Override
    public int delete(int id) throws Exception {
        System.out.println("service+=======");
        return appMapper.delete(id);
    }


    @Override
    public int deleteList(String[] pks) throws Exception {
        return appMapper.deleteList(pks);
    }

    @Override
    public App select(App entity) {
        return (App) appMapper.select(entity);
    }

    @Override
    public List<App> selectList(App entity) {
        return appMapper.selectListUseDyc(entity);
    }

    @Override
    public int selectCount(App entity) {
        System.out.println("base............." + entity);
        return appMapper.selectCountUserDyc(entity);
    }

    @Override
    public int getID(App entity) {
        return appMapper.selectID(entity);
    }
}
