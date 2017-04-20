package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.AppFilesService;
import com.tt.javaserver.web.vo.AppFiles;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppFilesServiceImpl extends BaseServiceImpl<AppFiles> implements AppFilesService {
    @Override
    public List<AppFiles> selectFiles(int appVersionId) {
        return appFilesMapper.selectFiles(appVersionId);
    }

    @Override
    public List<AppFiles> selectVersions(int fileId) {
        return appFilesMapper.selectVersions(fileId);
    }

    @Override
    public int selectCountFiles(int appVersionId) {
        return appFilesMapper.selectCountFiles(appVersionId);
    }

    @Override
    public int selectCountVersions(int fileId) {
        return appFilesMapper.selectCountVersions(fileId);
    }


    @Override
    public int update(AppFiles appFiles) {
        return appFilesMapper.update(appFiles);
    }

    @Override
    public int insert(AppFiles appFiles) throws Exception {
        System.out.println("appfile=======");
        return appFilesMapper.insert(appFiles);
    }
}
