package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.dao.*;
import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public SimpleResult deleteByStr(String code) {
        return null;
    }

    @Override
    public SimpleResult deleteByInt(int id) {
        return null;
    }

    @Override
    public SimpleResult insert(T entity) {
        return null;
    }

    @Override
    public SimpleResult update(T entity) {
        return null;
    }

    @Override
    public SimpleResult select(T entity) {
        return null;
    }

    /**
     * 获得当前时间
     *
     * @return
     */
    public long getCurrentTime() {
        long time = System.currentTimeMillis();
//        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
//        String StrFormatNowDate = sdFormatter.format(ct);
//        long time = Long.parseLong(StrFormatNowDate);
        return time;
    }
}
