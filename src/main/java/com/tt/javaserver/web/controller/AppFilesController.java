package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppFilesService;
import com.tt.javaserver.web.vo.AppFiles;
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
@RequestMapping("/appFiles")
public class AppFilesController extends BaseController {

    @Resource
    private AppFilesService appFilesService;

    /**
     *
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(AppFiles appFiles) {
        System.out.println("====add====");
        System.out.println(appFiles.toString());

        addUpdateAndCreateTime(appFiles);
        int i;
        try {
            System.out.println(123 + ";;;;;;;;;;;");
            i = appFilesService.insert(appFiles);
            System.out.println(i + ";;;;;;;;;;;");
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
            i = -1;
        }
        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();

        setResult(result, i);

        result.setData(data);
        System.out.println(result.toString());

        return result;

    }


    /**
     * 查询对象
     *
     * @param appFiles
     * @return
     */
    @RequestMapping("/queryVersion")
    @ResponseBody
    public SimpleResult<Map> queryVersion(AppFiles appFiles) {
        System.out.println("=============");
        System.out.println(appFiles.toString());

        int total = appFilesService.selectCountVersions(appFiles.getFileId());
        List<AppFiles> appVersionList = appFilesService.selectVersions(appFiles.getFileId());

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();
        setResult(result, total);
        data.put("total", total);
        data.put("versions", appVersionList);
        result.setData(data);
        System.out.println(result.toString());
        return result;
    }

    @RequestMapping("/queryFiles")
    @ResponseBody
    public SimpleResult<Map> queryFiles(AppFiles appFiles) {
        System.out.println("=============");
        System.out.println(appFiles.toString());

        int total = appFilesService.selectCountFiles(appFiles.getAppVersionId());
        List<AppFiles> appFilesList = appFilesService.selectFiles(appFiles.getAppVersionId());

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();
        setResult(result, total);
        data.put("total", total);
        data.put("files", appFilesList);
        result.setData(data);
        System.out.println(result.toString());
        return result;
    }

    /**
     * 更新appFiles指令
     *
     * @param appFiles
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public SimpleResult<Map> update(AppFiles appFiles) {
        System.out.println("=============");
        System.out.println(appFiles.toString());

        addUpdateTime(appFiles);

        int i = appFilesService.update(appFiles);
        SimpleResult<Map> result = new SimpleResult<>();
        setResult(result, i);

        System.out.println(result);
        return result;


    }

    /**
     * 删除
     *
     * @param appFiles
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(AppFiles appFiles) {
        System.out.println("=============");
        System.out.println(appFiles.toString());

        int i = 0;
        try {
            i = appFilesService.delete(appFiles.getAppVersionId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SimpleResult<Map> result = new SimpleResult<>();

        setResult(result, i);
        return result;
    }


    /**
     * 设置创建时间和更新时间
     *
     * @param appFiles
     */
    public void addUpdateAndCreateTime(AppFiles appFiles) {
        appFiles.setUpdateTime(getCurrentTime());
        appFiles.setCreateTime(getCurrentTime());
    }

    /**
     * 设置更新时间
     *
     * @param appFiles
     */
    public void addUpdateTime(AppFiles appFiles) {
        appFiles.setUpdateTime(getCurrentTime());
    }


}
