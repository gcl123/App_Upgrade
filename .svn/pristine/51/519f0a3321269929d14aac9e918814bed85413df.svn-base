package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppVersionService;
import com.tt.javaserver.web.vo.AppVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

        return appVersionService.insert(appVersion);
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

        return appVersionService.select(appVersion);
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

        return appVersionService.update(appVersion);
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

        return appVersionService.delete(appVersion);
    }

}
