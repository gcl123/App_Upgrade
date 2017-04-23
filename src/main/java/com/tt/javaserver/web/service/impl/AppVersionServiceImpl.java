package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.vo.AppVersion;
import org.springframework.stereotype.Service;

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
        int total = appVersionMapper.selectRecord(appVersion);
//        System.out.println(total + "total");
        if (total != 0) {
            return -1;
        }
        return appVersionMapper.insert(appVersion);
    }

}
