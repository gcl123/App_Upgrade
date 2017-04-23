package com.tt.javaserver.web.dao;

import com.tt.javaserver.web.vo.AppFiles;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppFilesMapper extends BaseMapper<AppFiles> {

    List<AppFiles> selectFiles(int appVersionId);

    List<AppFiles> selectVersions(int fileId);

    int selectCountFiles(int id);

    int selectCountVersions(int id);

}