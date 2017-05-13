package com.tt.javaserver.web.service;

import com.tt.javaserver.web.vo.App;
import com.tt.javaserver.web.vo.CurrentApp;
import com.tt.javaserver.web.vo.Page;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public interface AppService extends BaseService<App> {
     Map selectPageUseDyc(Page<App> page, HttpServletRequest request);


    CurrentApp selectCurApp(int id);

    /**
     * 通过公司主键,查找公司下面所有的app
     */
    List<App> selectByCompanyId(int companyId);
}
