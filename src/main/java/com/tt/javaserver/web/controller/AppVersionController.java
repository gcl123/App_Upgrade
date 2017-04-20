package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.vo.AppVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/20.
 */
@Controller
@RequestMapping("/version")
public class AppVersionController extends BaseController {
    @Resource
    private AppVersionService appVersionService;

    /**
     * 新增操作指令
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(AppVersion appVersion) {
        System.out.println("====add====");
        System.out.println(appVersion.toString());

        addUpdateAndCreateTime(appVersion);
        int i;
        try {
            i = appVersionService.insert(appVersion);
        } catch (Exception e) {
            i = -1;
        }
        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();

        setResult(result, i);
        try {
            data.put("id", appVersionService.getID(appVersion));
        } catch (Exception e) {
            data.put("id", null);
            e.printStackTrace();
        }
        result.setData(data);
        System.out.println(result.toString());

        return result;

    }


    /**
     * 查询对象
     *
     * @param appVersion
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(AppVersion appVersion) {
        System.out.println("=============");
        System.out.println(appVersion.toString());

        int total = appVersionService.selectCount(appVersion);
        List<AppVersion> appVersionList = appVersionService.selectList(appVersion);

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();
        setResult(result, total);
        data.put("total", total);
        data.put("appVersions", appVersionList);
        result.setData(data);
        return result;
    }


    /**
     * 更新appVersion指令
     *
     * @param appVersion
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public SimpleResult<Map> update(AppVersion appVersion) {
        System.out.println("=============");
        System.out.println(appVersion.toString());

        addUpdateTime(appVersion);
        int i = appVersionService.update(appVersion);
        SimpleResult<Map> result = new SimpleResult<>();
        setResult(result, i);

        System.out.println(result);
        return result;


    }

    /**
     * 删除
     *
     * @param appVersion
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(AppVersion appVersion) {
        System.out.println("=============");
        System.out.println(appVersion.toString());

        int i = appVersionService.delete(appVersion);
        SimpleResult<Map> result = new SimpleResult<>();

        setResult(result, i);
        return result;
    }


    /**
     * 设置创建时间和更新时间
     *
     * @param appVersion
     */
    public void addUpdateAndCreateTime(AppVersion appVersion) {
        appVersion.setUpdateTime(getCurrentTime());
        appVersion.setCreateTime(getCurrentTime());
    }

    /**
     * 设置更新时间
     *
     * @param appVersion
     */
    public void addUpdateTime(AppVersion appVersion) {
        appVersion.setUpdateTime(getCurrentTime());
    }


}
