package com.tt.javaserver.web.dao;

import com.tt.javaserver.web.vo.App;
import org.springframework.stereotype.Repository;

@Repository
public interface AppMapper extends BaseMapper<App> {

    int selectByAppcode(String appCode);
}
