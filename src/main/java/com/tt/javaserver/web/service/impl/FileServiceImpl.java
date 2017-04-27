package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.FileService;
import com.tt.javaserver.web.vo.File;
import com.tt.javaserver.web.vo.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class FileServiceImpl extends BaseServiceImpl<File> implements FileService {

    @Override
    public SimpleResult<Map> insert(File file) {
        addCreateTime(file);
        addUpdateTime(file);
        if (file == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (fileMapper.selectRecord(file) == 0) {
            if (fileMapper.insert(file) == 1) {
                SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
                Map<String, Object> data = new HashMap<>();
                data.put("id", file.getId());
                result.setData(data);
                return result;
            }
        }
        return new SimpleResult(-1, "插入失败");
    }

    @Override
    public SimpleResult<Map> delete(File file) {

        if (file == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (fileMapper.delete(file) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }


    @Override
    public SimpleResult update(File file) {
        addUpdateTime(file);
        if (file == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (fileMapper.update(file) == 1) {
            return new SimpleResult<>(0, "更新成功");
        }
        return new SimpleResult(-1, "更新失败");
    }

    @Override
    public SimpleResult select(File file) {

        if (file == null) {
            return new SimpleResult(-2, "数据为空");
        }
        int total = fileMapper.selectCount(file);
        List<File> fileList = fileMapper.selectList(file);

        if (total > 0 && fileList != null) {
            return new SimpleResult(0, "查询成功", total, "files", fileList);
        }
        return new SimpleResult(-1, "查询失败");
    }


    /**
     * 动态分页查询
     *
     * @param page
     * @return
     */
    public Map selectPageUseDyc(Page<File> page) {
        page.setList(fileMapper.selectPageListUseDyc(page));
        page.setTotalRecord(fileMapper.selectPageCountUseDyc(page));

        System.out.println("page========" + page.getPageMap());

        return page.getPageMap();
    }


    /**
     * 设置更新时间
     *
     * @param file
     */
    public void addUpdateTime(File file) {
        file.setUpdateTime(getCurrentTime());
    }

    /**
     * 设置创建时间
     *
     * @param file
     */
    public void addCreateTime(File file) {
        file.setCreateTime(getCurrentTime());
    }




}
