package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.vo.AppVersion;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppVersionServiceImpl extends BaseServiceImpl<AppVersion> implements AppVersionService {


    @Override
    public int delete(AppVersion appVersion) {
        return appVersionMapper.delete(appVersion);
    }


    @Override
    public int insert(AppVersion appVersion) {
        int total = appVersionMapper.selectVersionTotal(appVersion);
        System.out.println(total + "total");
        if (total != 0) {
            return -1;
        }
        return appVersionMapper.insert(appVersion);
    }

    @Override
    public int getID(AppVersion appVersion) {
        return appVersionMapper.selectID(appVersion);
    }

    @Override
    public List<AppVersion> selectList(AppVersion appVersion) {
        return appVersionMapper.selectList(appVersion);
    }

    @Override
    public int selectCount(AppVersion appVersion) {
        return appVersionMapper.selectCount(appVersion);
    }

    @Override
    public int update(AppVersion appVersion) {
        return appVersionMapper.update(appVersion);
    }
}
