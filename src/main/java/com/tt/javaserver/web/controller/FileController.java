package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.FileService;
import com.tt.javaserver.web.vo.File;
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
        System.out.println("====add====");
        System.out.println(file.toString());

        addUpdateAndCreateTime(file);
        int i;
        try {
            i = fileService.insert(file);
        } catch (Exception e) {
            i = -1;
        }
        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();

        setResult(result, i);
        data.put("id", file.getId());

        result.setData(data);
        System.out.println(result.toString());

        return result;

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
        System.out.println("=============");
        System.out.println(file.toString());

        int total = fileService.selectCount(file);
        List<File> fileList = fileService.selectList(file);

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();
        setResult(result, total);
        data.put("total", total);
        data.put("files", fileList);
        result.setData(data);
        System.out.println(result.toString());
        return result;
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
        System.out.println("=============");
        System.out.println(file.toString());

        addUpdateTime(file);
        int i = fileService.update(file);
        SimpleResult<Map> result = new SimpleResult<>();
        setResult(result, i);

        System.out.println(result);
        return result;


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

        int i = 0;
        try {
            i = fileService.delete(file.getId());
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
     * @param file
     */
    public void addUpdateAndCreateTime(File file) {
        file.setUpdateTime(getCurrentTime());
        file.setCreateTime(getCurrentTime());
    }

    /**
     * 设置更新时间
     *
     * @param file
     */
    public void addUpdateTime(File file) {
        file.setUpdateTime(getCurrentTime());
    }


}
