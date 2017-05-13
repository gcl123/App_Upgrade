package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.ActionService;
import com.tt.javaserver.web.vo.Action;
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
 * Created by GCL on 17/4/15.
 */

@Controller
@RequestMapping("/action")
public class ActionController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActionController.class);
    
    @Resource
    private ActionService actionService;

    /**
     * 新增操作指令
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(Action action) throws Exception {
        LOGGER.info("====add====" + action);

        if (action == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (actionService.insert(action) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
            Map<String, Object> data = new HashMap<>();
            data.put("code", action.getCode());
            result.setData(data);
            System.out.println("=======" + result);
            return result;
        }
        return new SimpleResult(-1, "插入失败,指令已存在");
    }


    /**
     * 查询对象
     *
     * @param action
     * @return
     */
    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(Action action) {
        LOGGER.info("=============");
        LOGGER.info(action.toString());
        return actionService.select(action);

    }


    /**
     * 更新action指令
     *
     * @param action
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public SimpleResult<Map> update(Action action) {
        LOGGER.info("update=============" + action);

        if (action == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (actionService.update(action) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    /**
     * 删除
     *
     * @param code
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(String  code) {
        LOGGER.info("delete============="+code);
        if (code == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (actionService.deleteByStr(code) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");

    }


    //通过关键字分页查询
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody
    public Object selectPageUseDyc(Page<Action> page) {
        LOGGER.info("page=:" + page );
        return actionService.selectPageUseDyc(page);
    }


}
