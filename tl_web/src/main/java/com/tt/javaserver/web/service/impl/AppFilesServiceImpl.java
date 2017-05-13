package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.AppFilesService;
import com.tt.javaserver.web.vo.AppFiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppFilesServiceImpl extends BaseServiceImpl<AppFiles> implements AppFilesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppFilesServiceImpl.class);


    @Override
    public int insert(AppFiles appFiles) {
        addCreateTime(appFiles);
        addUpdateTime(appFiles);

        int r = 0;
        try {
            return appFilesMapper.insert(appFiles);
        }catch (Exception e){
            return r;
        }
    }


    @Override
    public int deleteByInt(int appVersionId) {
        int r = 0;
        try {
            return appFilesMapper.deleteByInt(appVersionId);
        }catch (Exception e){
            return r;
        }
    }

    @Override
    public int update(AppFiles appFiles) {
        addUpdateTime(appFiles);

        int r = 0;
        try {
            return appFilesMapper.update(appFiles);
        }catch (Exception e){
            return r;
        }
    }

    public List<AppFiles> selectFilesByVersionId(int appVersionId) {

//        int total = appFilesMapper.selectCountFiles(appVersionId);
        List<AppFiles> appFilesList = appFilesMapper.selectFiles(appVersionId);
        if (appFilesList != null) {
            return appFilesList;
        }
        return null;
    }

//    public List<AppVersion> selectVersionsByFileId(int fileId) {
//
//        if (fileId == 0) {
//            return new SimpleResult(-2, "数据为空");
//        }
//        int total = appFilesMapper.selectCountVersions(fileId);
//        List<AppFiles> appVersionList = appFilesMapper.selectVersions(fileId);
//
//        if (total > 0 && appVersionList != null) {
//            return new SimpleResult(0, "查询成功", total, "appVersions", appVersionList);
//        }
//        return new SimpleResult(-1, "查询失败");
//    }


    /**
     * 设置更新时间
     *
     * @param appFiles
     */
    public void addUpdateTime(AppFiles appFiles) {
        appFiles.setUpdateTime(getCurrentTime());
    }

    /**
     * 设置创建时间
     *
     * @param appFiles
     */
    public void addCreateTime(AppFiles appFiles) {
        appFiles.setCreateTime(getCurrentTime());
    }


}
