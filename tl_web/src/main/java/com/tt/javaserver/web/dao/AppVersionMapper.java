package com.tt.javaserver.web.dao;

import com.tt.javaserver.web.vo.AppVersion;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface AppVersionMapper extends BaseMapper<AppVersion> {

    List<AppVersion> selectVersionByAppId(int appId);

    AppVersion selectVersion(@Param("appId") Integer id, @Param("version") String latestVersion);

    int selectVersionCount(int appId);
}