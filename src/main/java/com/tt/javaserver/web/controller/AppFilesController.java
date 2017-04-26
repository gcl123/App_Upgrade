package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppFilesService;
import com.tt.javaserver.web.vo.AppFiles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

        return appFilesService.insert(appFiles);

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

        return appFilesService.selectVersionsByFileId(appFiles.getFileId());
    }

    @RequestMapping("/queryFiles")
    @ResponseBody
    public SimpleResult<Map> queryFiles(AppFiles appFiles) {
        System.out.println("=============");
        System.out.println(appFiles.toString());

        return appFilesService.selectFilesByVersionId(appFiles.getAppVersionId());
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

        return appFilesService.update(appFiles);
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
        return appFilesService.deleteByInt(appFiles.getAppVersionId());
    }



}
