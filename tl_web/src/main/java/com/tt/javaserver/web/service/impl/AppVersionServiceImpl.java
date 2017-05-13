package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.vo.AppVersion;
import com.tt.javaserver.web.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppVersionServiceImpl extends BaseServiceImpl<AppVersion> implements AppVersionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppVersionServiceImpl.class);
    @Resource
    HttpServletRequest request;
    @Override
    public int insert(AppVersion appVersion) {
        addCreateTime(appVersion);
        addUpdateTime(appVersion);

        int r = 0;
        try {
            if(appVersionMapper.selectRecord(appVersion) == 0){
                LOGGER.info("appverADD");
                try {
                    r = appVersionMapper.insert(appVersion);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return r;
            }
            LOGGER.info("appverADD-2");
            return -2;
        }catch (Exception e){
            return r;
        }
    }

    @Override
    public int deleteByInt(int id) {
        int r = 0;
        try {
            return appVersionMapper.deleteByInt(id);
        }catch (Exception e){
            return r;
        }
    }

    @Override
    public int update(AppVersion appVersion) {
        addUpdateTime(appVersion);
        int r = 0;
        try {
            return appVersionMapper.update(appVersion);
        }catch (Exception e){
            e.printStackTrace();
            return r;
        }
    }


    @Override
    public AppVersion select(int id) {
       return appVersionMapper.selectById(id);
    }

    /**
     * 分页查询
     * @param page
     * @return
     */
    @Override
    public Map selectPageUseDyc(Page<AppVersion> page) {
        List<AppVersion> appVersionList = appVersionMapper.selectPageListUseDyc(page);
        int total = appVersionMapper.selectPageCountUseDyc(page);

        Iterator it = appVersionList.iterator();
        while (it.hasNext()) {
            AppVersion appVersion = (AppVersion) it.next();
            String statusInfo = "不可用";
            try {
                int status = appVersion.getStatus();
                if(status == 0){
                    statusInfo = "不可用";
                }else if(status==1){
                    statusInfo ="可用";
                }else  if(status == 9){
                    statusInfo = "测试中";
                }
                appVersion.setStatusInfo(statusInfo);

            } catch (Exception e) {

            }
        }
        page.setList(appVersionList);
        page.setTotalRecord(total);


        LOGGER.info("appversion  page map "+page.getPageMap());
        return page.getPageMap();
    }




    /**
     * 将版本状态添加到session
     */
    @Override
    public void setStatus() {
        Map<Integer,String> statusMap = new HashMap<>();
        statusMap.put(0,"不可用");
        statusMap.put(1,"可用");
        statusMap.put(9,"测试中");
        request.getSession().setAttribute("statusParams",statusMap);
    }

    @Override
    public int setVersion2session(int appId) {
        int r = 0;
        try{
            List<AppVersion> appVersionList = appVersionMapper.selectVersionByAppId(appId);
            List versionList = new LinkedList();
            Iterator it = appVersionList.iterator();
            while (it.hasNext()){
                AppVersion appVersion = (AppVersion)it.next();
                String version = appVersion.getVersion();
                versionList.add(version);
            }
            request.getSession().setAttribute("versionList",versionList);
            return 1;
        }catch (Exception e){
            return r;
        }

    }

    @Override
    public AppVersion selectVersion(Integer id, String latestVersion) {
        return appVersionMapper.selectVersion(id,latestVersion);
    }

    /**
     *
     * @param appId 对应app表id
     * @return
     */
    @Override
    public int selectVersionCount(int appId) {
        return appVersionMapper.selectVersionCount(appId);
    }

    @Override
    public int setVersionStatus(int appId, String limitVersion) {
        List<AppVersion> appVersionList = appVersionMapper.selectVersionByAppId(appId);
        LOGGER.info("total"+appVersionList.size());

        for (AppVersion appVersion : appVersionList) {
           if(appVersion.getVersion().compareTo(limitVersion) < 0){
               appVersion.setStatus(0);
               LOGGER.info("status");
               update(appVersion);

           }
        }
        return 1;
    }

    @Override
    public List<AppVersion> selectVersionByAppId(int appId) {
        try {
            return appVersionMapper.selectVersionByAppId(appId);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    /**
     * 设置更新时间
     *
     * @param appVersion
     */
    public void addUpdateTime(AppVersion appVersion) {
        appVersion.setUpdateTime(getCurrentTime());
    }

    /**
     * 设置创建时间
     *
     * @param appVersion
     */
    public void addCreateTime(AppVersion appVersion) {
        appVersion.setCreateTime(getCurrentTime());
    }



}
