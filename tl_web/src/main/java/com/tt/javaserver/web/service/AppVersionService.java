package com.tt.javaserver.web.service;

import com.tt.javaserver.web.vo.AppVersion;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public interface AppVersionService extends BaseService<AppVersion> {
    void setStatus();

    int setVersion2session(int appId);

    AppVersion selectVersion(Integer id, String latestVersion);

    int selectVersionCount(int appId);

    int setVersionStatus(int appId, String limitVersion);

    List<AppVersion> selectVersionByAppId(int appId);

}

