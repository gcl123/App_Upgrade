package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.FileService;
import com.tt.javaserver.web.vo.File;
import org.springframework.stereotype.Service;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class FileServiceImpl extends BaseServiceImpl<File> implements FileService {

    public int delete(File file) {
        return fileMapper.deleteByInt(file.getId());
    }


    @Override
    public int insert(File file) {
        int total = fileMapper.selectRecord(file);
        if (total != 0) {
            return -1;
        }
        return fileMapper.insert(file);
    }


}
