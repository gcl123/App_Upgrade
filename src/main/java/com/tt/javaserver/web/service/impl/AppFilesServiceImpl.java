package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppFilesService;
import com.tt.javaserver.web.vo.AppFiles;
import com.tt.javaserver.web.vo.AppVersion;
import com.tt.javaserver.web.vo.File;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppFilesServiceImpl extends BaseServiceImpl<AppFiles> implements AppFilesService {

    @Override
    public SimpleResult<Map> insert(AppFiles appFiles) {
        addCreateTime(appFiles);
        addUpdateTime(appFiles);
        if (appFiles == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appFilesMapper.selectRecord(appFiles) == 0) {
            if (appFilesMapper.insert(appFiles) == 1) {
                SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
                return result;
            }
        }
        return new SimpleResult(-1, "插入失败,指令已存在");
    }

    @Override
    public SimpleResult<Map> insertList(List<File> files, AppVersion version) {
        if (files == null || version == null) {
            return new SimpleResult(-2, "数据为空");
        }
        int size = files.size();
        if(appMapper.selectRecordById(version.getAppId())==0){
            //第一次上传软件
            if(appVersionMapper.selectRecord(version)==0){
                if( appVersionMapper.insert(version)==1 ){
                    Iterator it = files.iterator();
                    while(it.hasNext()){
                        File file = (File) it.next();
                        System.out.println(file);
                        if (fileMapper.selectRecord(file) == 0) {
                            if(fileMapper.insert(file)==1){
                                AppFiles appFiles = new AppFiles();
                                appFiles.setAppVersionId(version.getId());
                                appFiles.setFileId(file.getId());
                                if(appFilesMapper.insert(appFiles)==1){
                                    size--;
                                }
                            }
                        }else {
                            int fileId = fileMapper.selectIdByMD5(file);
                            if(fileId != 0){
                                AppFiles appFiles = new AppFiles();
                                appFiles.setAppVersionId(version.getId());
                                appFiles.setFileId(fileId);
                                if(appFilesMapper.insert(appFiles)==1){
                                    size--;
                                }
                            }
                        }

                    }
                }
            }else {
                return new SimpleResult<>(-1,"该软件版本已存在");
            }
        }else{
            if(appVersionMapper.selectRecord(version)==0 ){
                if(appVersionMapper.insert(version)==1 ){
                    Iterator it = files.iterator();
                    while(it.hasNext()){
                        File file = (File) it.next();
                        int fileId = 0;
                        try {
                            fileId = fileMapper.selectIdByMD5(file);
                        }catch (Exception e ){
                            e.printStackTrace();
                        }
                        if( fileId != 0){
                            AppFiles appFiles = new AppFiles();
                            appFiles.setAppVersionId(version.getId());
                            appFiles.setFileId(fileId);
                            if(appFilesMapper.insert(appFiles)==1){
                                size--;
                            }
                        }else {
                            if (fileMapper.insert(file)==1 ) {
                                AppFiles appFiles = new AppFiles();
                                appFiles.setAppVersionId(version.getId());
                                appFiles.setFileId(file.getId());
                                appFilesMapper.insert(appFiles);
                                if(appFilesMapper.insert(appFiles)==1){
                                    size--;
                                }
                            }
                        }
                    }
                }
            }else {
                return new SimpleResult<>(-1,"该软件版本已经存在");
            }
        }
        if(size == 0){
            SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
            return result;
        }
        return new SimpleResult(-1, "插入失败");
    }

    @Override
    public SimpleResult<Map> deleteByInt(int appVersionId) {
        if (appVersionId == 0) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appFilesMapper.deleteByInt(appVersionId) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }

    @Override
    public SimpleResult update(AppFiles appFiles) {
        addUpdateTime(appFiles);
        if (appFiles == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appFilesMapper.update(appFiles) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    public SimpleResult selectFilesByVersionId(int appVersionId) {

        if (appVersionId == 0) {
            return new SimpleResult(-2, "数据为空");
        }
        int total = appFilesMapper.selectCountFiles(appVersionId);
        List<AppFiles> appFilesList = appFilesMapper.selectFiles(appVersionId);

        if (total > 0 && appFilesList != null) {
            return new SimpleResult(0, "查询成功", total, "appFiles", appFilesList);
        }
        return new SimpleResult(-1, "查询失败");
    }

    public SimpleResult selectVersionsByFileId(int fileId) {

        if (fileId == 0) {
            return new SimpleResult(-2, "数据为空");
        }
        int total = appFilesMapper.selectCountVersions(fileId);
        List<AppFiles> appVersionList = appFilesMapper.selectVersions(fileId);

        if (total > 0 && appVersionList != null) {
            return new SimpleResult(0, "查询成功", total, "appVersions", appVersionList);
        }
        return new SimpleResult(-1, "查询失败");
    }


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
