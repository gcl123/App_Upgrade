package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.FileService;
import com.tt.javaserver.web.vo.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by GCL on 17/4/20.
 */
@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

    @Resource
    private FileService fileService;

    /**
     * 新增操作指令
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(File file) {
        System.out.println("add=====");
        System.out.println(file.toString());

        return fileService.insert(file);
    }


    /**
     * 查询对象
     *
     * @param file
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(File file) {
        System.out.println("query=========");
        System.out.println(file.toString());

        return fileService.select(file);
    }


    /**
     * 更新file指令
     *
     * @param file
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public SimpleResult<Map> update(File file) {
        System.out.println("update===========");
        System.out.println(file.toString());

        return fileService.update(file);
    }

    /**
     * 删除
     *
     * @param file
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(File file) {
        System.out.println("=============");
        System.out.println(file.toString());

        return fileService.delete(file);
    }

}
