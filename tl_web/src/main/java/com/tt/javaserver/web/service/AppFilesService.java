package com.tt.javaserver.web.service;

import com.tt.javaserver.web.vo.AppFiles;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public interface AppFilesService extends BaseService<AppFiles> {

//    List<AppVersion> selectVersionsByFileId(int fileId);
    List<AppFiles> selectFilesByVersionId(int appVersionId);

}
