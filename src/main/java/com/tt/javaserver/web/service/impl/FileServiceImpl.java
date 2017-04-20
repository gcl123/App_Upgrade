package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.FileService;
import com.tt.javaserver.web.vo.File;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class FileServiceImpl extends BaseServiceImpl<File> implements FileService {

    public int delete(File file) {
        return fileMapper.delete(file.getId());
    }


    @Override
    public int insert(File file) {
        int total = fileMapper.selectVersionTotal(file);
        if (total != 0) {
            return -1;
        }
        return fileMapper.insert(file);
    }

    @Override
    public int getID(File file) {
        return fileMapper.selectID(file);
    }

    @Override
    public List<File> selectList(File file) {
        return fileMapper.selectList(file);
    }

    @Override
    public int selectCount(File file) {
        System.out.println("file=====" + file);
        return fileMapper.selectCount(file);
    }

    @Override
    public int update(File file) {
        return fileMapper.update(file);
    }

    @Override
    public int delete(int id) throws Exception {
        System.out.println("service+=======");
        return fileMapper.delete(id);
    }


}
