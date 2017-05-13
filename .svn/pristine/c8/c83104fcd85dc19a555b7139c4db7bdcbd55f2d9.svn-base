package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.FileService;
import com.tt.javaserver.web.vo.File;
import com.tt.javaserver.web.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by GCL on 17/4/20.
 */
@Controller
@RequestMapping("/file")
public class FileController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Resource
    private FileService fileService;

    /**
     * 新增操作指令
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(File file) {
        LOGGER.info("add=====");
        LOGGER.info(file.toString());

        if (file == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (fileService.insert(file) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "插入文件成功");
            Map<String, Object> data = new HashMap<>();
            data.put("id", file.getId());
            result.setData(data);
            return result;
        }
        return new SimpleResult(-1, "插入失败");
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
        LOGGER.info("query=========");
        LOGGER.info(file.toString());

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
        LOGGER.info("update==========="+file);

        if (file == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (fileService.update(file) > 0) {
            return new SimpleResult<>(0, "更新成功");
        }
        return new SimpleResult(-1, "更新失败");
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
        LOGGER.info("del============="+file);

        if (file == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (fileService.delete(file) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }

    //通过关键字分页查询
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
    public Object selectPageUseDyc(Page<File> page, File file) {

        page.setParamEntity(file);
        LOGGER.info("page==========:" + page);
        return fileService.selectPageUseDyc(page);
    }


}
