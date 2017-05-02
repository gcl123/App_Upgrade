package com.tt.javaserver.web.service;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.vo.AppFiles;
import com.tt.javaserver.web.vo.AppVersion;
import com.tt.javaserver.web.vo.File;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public interface AppFilesService extends BaseService<AppFiles> {

    SimpleResult selectVersionsByFileId(int fileId);

    SimpleResult selectFilesByVersionId(int appVersionId);

    SimpleResult<Map> insertList(List<File> files, AppVersion appVersion);
}
