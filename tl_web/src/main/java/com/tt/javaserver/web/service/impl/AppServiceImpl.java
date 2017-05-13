package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.vo.App;
import com.tt.javaserver.web.vo.Company;
import com.tt.javaserver.web.vo.CurrentApp;
import com.tt.javaserver.web.vo.Page;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService {


    @Override
    public int insert(App app) {
        addCreateTime(app);
        addUpdateTime(app);

        int r = 0;
        try {
            if(appMapper.selectRecord(app) == 0){
                return appMapper.insert(app);
            }
            return -2;
        }catch (Exception e) {
            return r;
        }
    }

    @Override
    public int deleteByInt(int  id) {
        int r = 0;
        try {
            return appMapper.deleteByInt(id);
        }catch (Exception e) {
            return r;
        }

    }

    public int update(App app) {
        addUpdateTime(app);
        int r = 0;
        try {
            return appMapper.update(app);
        }catch (Exception e) {
            e.printStackTrace();
            return r;
        }
    }

    @Override
    public SimpleResult select(App app) {
        if (app == null) {
            return new SimpleResult(-2, "数据为空", 0, "apps", null);
        }
        int total = appMapper.selectCount(app);
        List<App> appList = appMapper.selectList(app);

        if (total > 0 && appList != null) {
            return new SimpleResult(0, "查询成功", total, "apps", appList);
        }
        return new SimpleResult(-1, "查询失败");
    }


    /**
     * 分页显示
     * @param page
     * @param request
     * @return
     */
    @Override
    public Map selectPageUseDyc(Page<App> page,HttpServletRequest request) {
        List<App> appList = appMapper.selectPageListUseDyc(page);
        int total = appMapper.selectPageCountUseDyc(page);

        //将app对应公司ID,变为公司名称
        Iterator it = appList.iterator();
        while (it.hasNext()) {
            App app = (App) it.next();
            String companyName;
            try {
                companyName = companyMapper.selectById(app.getCompanyId()).getName();
                app.setCompanyName(companyName);
            } catch (Exception e) {
            }
        }
            page.setList(appList);
            page.setTotalRecord(total);
//        setCompany2session(request,appList);

        return page.getPageMap();
    }
    /**
     * app 显示是将companyID 变为 名称
     * @param appList
     */
    public void setCompany2session(HttpServletRequest request,List appList){
        Map<Integer,String> companyIdAndName = new HashMap<>();
        Iterator it = appList.iterator();
        while (it.hasNext()){
            App app = (App) it.next();
            String companyName = null;
            try {
                companyName = companyMapper.selectById(app.getCompanyId()).getName();
            }catch (Exception e){

            }
            companyIdAndName.put(app.getCompanyId(),companyName);
        }
        request.getSession().setAttribute("appParams",companyIdAndName);
    }


    /**
     * 当前 app 信息 ,全局显示
     * @param id
     * @return
     */
    @Override
    public CurrentApp selectCurApp(int id) {
        if(id == 0){
            return null;
        }
        CurrentApp currentApp = new CurrentApp();
        App app = appMapper.selectById(id);
        if(app == null){
            return null;
        }else {
            Company company = companyMapper.selectById(app.getCompanyId());
            if(company != null){
                currentApp.setId(id);
                currentApp.setAppCode(app.getAppCode());
                currentApp.setAppName(app.getAppName());
                currentApp.setLatestVersion(app.getLatestVersion());
                currentApp.setCompanyCode(company.getCode());
                currentApp.setCompanyName(company.getName());
                return currentApp;
            }else {
                return null;
            }

        }
    }


    @Override
    public List<App> selectByCompanyId(int companyId) {
        return appMapper.selectByCompanyId(companyId);
    }

    /**
     * 设置更新时间
     *
     * @param app
     */
    public void addUpdateTime(App app) {
        app.setUpdateTime(getCurrentTime());
    }

    /**
     * 设置创建时间
     *
     * @param app
     */
    public void addCreateTime(App app) {
        app.setCreateTime(getCurrentTime());
    }


}
