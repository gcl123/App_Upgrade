package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.service.CompanyService;
import com.tt.javaserver.web.vo.App;
import com.tt.javaserver.web.vo.CurrentApp;
import com.tt.javaserver.web.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */

@Controller
@RequestMapping("/app")
public class AppController extends BaseController {
    @Resource
    private AppService appService;
    @Resource
    private AppVersionService appVersionService;

    @Resource
    private CompanyService companyService;

    private static final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    /**
     * 添加app
     *
     * @param app
     * @return
     * @throws Exception
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(App app,HttpServletRequest request) {
        LOGGER.info("insert============="+app);
        if (app == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appService.insert(app) > 0) {
            CurrentApp currentApp =  appService.selectCurApp(app.getId());
//            request.getSession().removeAttribute("curApp");
            request.getSession().setAttribute("curApp",currentApp);

            LOGGER.info("curApp===add"+currentApp);

            SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
            Map<String, Object> data = new HashMap<>();
            data.put("id", app.getId());
            result.setData(data);
            return result;
        }
        return new SimpleResult(-1, "插入失败,软件存在");
    }

    /**
     * 查询对象
     *
     * @param app
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(App app) {
        LOGGER.info("query============="+app);
        return appService.select(app);
    }


    /**
     * 更新对象
     *
     * @param app
     * @throws Exception
     */
    @RequestMapping("/update")
    @ResponseBody
    public SimpleResult<Map> update(App app) {
        LOGGER.info("update============="+app);
        if (app == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appService.update(app) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    /**
     * 删除对象
     *
     * @param id
     *
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(int id) {
        LOGGER.info("delete============="+id);
        if (id == 0) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appService.deleteByInt(id) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }

    //通过关键字分页查询
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
    public Object selectPageUseDyc(Page<App> page, HttpServletRequest request) {
        LOGGER.info("page=:" + page );
        companyService.setCompany2session(request);
        return appService.selectPageUseDyc(page,request);
    }

    /**
     * 设为当前软件()
     * @param id
     * @param
     * @return
     */
    @RequestMapping("/curApp")
    @ResponseBody
    public SimpleResult curApp(int id,HttpServletRequest request) {
        LOGGER.info("curApp==========:" + id );
        if(id == 0){
            return new SimpleResult(-2,"数据为空");
        }
        request.getSession().removeAttribute("curApp");
        CurrentApp currentApp =  appService.selectCurApp(id);
        request.getSession().setAttribute("curApp",currentApp);
        if(currentApp != null){
            return new SimpleResult(0,"设置为当前app成功");
        }
        return new SimpleResult(-1,"设置为当前app失败");
    }



    /**
     * 设为最新版本
     * @param id
     * @param latestVersion
     * @return
     */
    @RequestMapping("/setLatestVersion")
    @ResponseBody
    public SimpleResult setLatestVersion(int id,String latestVersion) {

        LOGGER.info("app--setMinVersion==========id:" + id );
        LOGGER.info("app--setMinVersion==========version:" + latestVersion );

        if(id == 0 || latestVersion == null){
            return new SimpleResult(-2,"数据为空");
        }
        App app = new App();
        app.setId(id);
        app.setLatestVersion(latestVersion);
        return update(app);
    }

    /**
     * 将软件所有版本存储到session中  sessionScope.versionList
     * @param appId
     * @param request
     * @return
     */
    @RequestMapping("/setVersion2session")
    @ResponseBody
    public SimpleResult setVersion2session(int appId,HttpServletRequest request) {

        LOGGER.info("app--setMinVersion==========:" + appId );

        if(appId == 0){
            return new SimpleResult(-2,"数据为空");
        }
        if(appVersionService.setVersion2session(appId) > 0){
            return new SimpleResult(0,"设置最小版本成功");
        }
        return new SimpleResult(-1,"设置最小版本失败");
    }


    @RequestMapping("/selectCompanyApp")
    @ResponseBody
    public SimpleResult<Map> selectComapnyApp(int companyId){
        LOGGER.info("selectCompanyApp"+companyId);
        if(companyId == 0) {
            return new SimpleResult<>(-2,"数据为空");
        }
        List<App> appList = appService.selectByCompanyId(companyId);
        if(appList != null ){
            SimpleResult<Map> result =  new SimpleResult<>(0,"公司的软件");
            Map map = new HashMap();
            map.put("total",appList.size());
            map.put("apps",appList);
            result.setData(map);
            return result;
        }
        return new SimpleResult<>(-1,"对应软件不存在");

    }




}
