package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.vo.App;
import org.springframework.stereotype.Service;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService {
    @Override
    public int delete(App app) {
        return appMapper.deleteByStr(app.getAppCode());
    }
    @Override
    public int insert(App app) throws Exception {
        System.out.println("base=======insert" + app);
        int total = appMapper.selectRecord(app);
        System.out.println(total + "total");
        if (total != 0) {
            return -1;
        }
        return appMapper.insert(app);
    }
}
