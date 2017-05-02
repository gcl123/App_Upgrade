package com.tt.javaserver.web.dao;

import com.tt.javaserver.web.vo.File;
import com.tt.javaserver.web.vo.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileMapper extends BaseMapper<File> {

    //通过关键字分页查询数据列表
    List<File> selectPageListUseDyc(Page<File> page);

    //通过关键字分页查询，返回总记录数
    Integer selectPageCountUseDyc(Page<File> page);

    Integer selectIdByMD5(File file);
}