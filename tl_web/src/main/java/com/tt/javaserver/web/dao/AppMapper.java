package com.tt.javaserver.web.dao;

import com.tt.javaserver.web.vo.App;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppMapper extends BaseMapper<App> {

    int selectRecordById(int id);

    List<App> selectByCompanyId(int companyId);
}

