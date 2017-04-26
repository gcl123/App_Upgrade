package com.tt.javaserver.web.service;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.vo.File;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public interface FileService extends BaseService<File> {

    SimpleResult<Map> delete(File file);

}
