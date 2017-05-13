package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.dao.*;
import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.BaseService;
import com.tt.javaserver.web.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {

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

    @Override
    public int deleteByStr(String code) {
        return 0;
    }

    @Override
    public int deleteByInt(int id) {
        return 0;
    }

    @Override
    public Map selectPageUseDyc(Page<T> page) {
        return null;
    }

    @Override
    public int insert(T entity) {
        return 0;
    }

    @Override
    public int update(T entity) {
        return 0;
    }

    @Override
    public SimpleResult<Map> select(T entity) {
        return null;
    }

    @Override
    public T select(int id) {
        return baseMapper.selectById(id);
    }

    @Override
    public int selectTotal(T entity) {
        return baseMapper.selectCount(entity);
    }

    @Override
    public List<T> selectList(T entity) {
        return baseMapper.selectList(entity);
    }

}
