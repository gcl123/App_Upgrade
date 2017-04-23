package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.vo.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

        addCreateTime(app);
        addUpdateTime(app);
        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();
        int flag = 0;
        try {
            flag = appService.insert(app);
        } catch (Exception e) {
            flag = -1;
            e.printStackTrace();
        }
        setResult(result, flag);
        try {
            data.put("id", appService.getID(app));
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.setData(data);

        System.out.println("result====" + result);
        return result;

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

        List<App> appList = appService.selectList(app);
        int total = appService.selectCount(app);

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();

        setResult(result, total);

        data.put("total", total);
        data.put("apps", appList);
        result.setData(data);
        return result;
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
        addUpdateTime(app);

        int i = appService.update(app);
        System.out.println("update=====late======" + i);


        SimpleResult<Map> result = new SimpleResult<>();
        setResult(result, i);

        System.out.println("result====" + result);
        return result;

    }

    /**
     * 删除对象
     *
     * @param app
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(App app) throws Exception {
        System.out.println("delete=============");
        System.out.println(app);
        int i = -1;

        i = appService.delete(app);
        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();
        setResult(result, i);

        return result;
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
