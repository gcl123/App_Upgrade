package com.tt.javaserver.web.dao;

import com.tt.javaserver.web.vo.AppVersion;
import org.springframework.stereotype.Repository;

@Repository

public interface AppVersionMapper extends BaseMapper<AppVersion> {

    int delete(AppVersion appVersion);


}