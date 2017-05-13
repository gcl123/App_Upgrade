package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.vo.AppVersion;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppVersionServiceImpl extends BaseServiceImpl<AppVersion> implements AppVersionService {

    @Override
    public SimpleResult<Map> insert(AppVersion appVersion) {
        addCreateTime(appVersion);
        addUpdateTime(appVersion);
        if (appVersion == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appVersionMapper.selectRecord(appVersion) == 0) {
            if (appVersionMapper.insert(appVersion) == 1) {
                SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
                Map<String, Object> data = new HashMap<>();
                data.put("id", appVersion.getId());
                return result;
            }
        }
        return new SimpleResult(-1, "插入失败");
    }

    public SimpleResult<Map> delete(AppVersion appVersion) {

        if (appVersion == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appVersionMapper.delete(appVersion) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }

    @Override
    public SimpleResult update(AppVersion appVersion) {
        addUpdateTime(appVersion);
        if (appVersion == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appVersionMapper.update(appVersion) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    @Override
    public SimpleResult select(AppVersion appVersion) {
        if (appVersion == null) {
            return new SimpleResult(-2, "数据为空");
        }
        int total = appVersionMapper.selectCount(appVersion);
        List<AppVersion> versionList = appVersionMapper.selectList(appVersion);

        if (total > 0 && versionList != null) {
            return new SimpleResult(0, "查询成功", total, "versions", versionList);
        }
        return new SimpleResult(-1, "查询失败");
    }


    /**
     * 设置更新时间
     *
     * @param appVersion
     */
    public void addUpdateTime(AppVersion appVersion) {
        appVersion.setUpdateTime(getCurrentTime());
    }

    /**
     * 设置创建时间
     *
     * @param appVersion
     */
    public void addCreateTime(AppVersion appVersion) {
        appVersion.setCreateTime(getCurrentTime());
    }




}
