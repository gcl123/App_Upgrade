package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.vo.App;
import com.tt.javaserver.web.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */

@Controller
@RequestMapping("/app")
public class AppController extends BaseController {
    @Resource
    private AppService appService;

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
    public SimpleResult<Map> insert(App app) {
        System.out.println("insert=============");
        System.out.println(app);

        return appService.insert(app);

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

        System.out.println("query=============");
        System.out.println(app);
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
        System.out.println("update=============");
        System.out.println(app.toString());
        return appService.update(app);

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
    public SimpleResult<Map> delete(int id) throws Exception {
        System.out.println("delete=============");
        System.out.println(id);

        return appService.deleteByInt(id);
    }

    //通过关键字分页查询
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
    public Object selectPageUseDyc(Page<App> page, App app) {

        app.setAppName(" ");
        page.setParamEntity(app);
        System.out.println("page==========:" + page + "=======" + app);

        return appService.selectPageUseDyc(page);
    }



}
