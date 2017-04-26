package com.tt.javaserver.web.service;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.vo.AppFiles;
import org.springframework.stereotype.Service;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public interface AppFilesService extends BaseService<AppFiles> {

    SimpleResult selectVersionsByFileId(int fileId);

    SimpleResult selectFilesByVersionId(int appVersionId);


}
