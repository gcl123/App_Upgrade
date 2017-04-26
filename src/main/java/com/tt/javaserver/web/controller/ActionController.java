package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.ActionService;
import com.tt.javaserver.web.vo.Action;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */

@Controller
@RequestMapping("/action")
public class ActionController extends BaseController {
    @Resource
    private ActionService actionService;

    /**
     * 新增操作指令
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(Action action) throws Exception {
        System.out.println("====add====" + action);
        System.out.println(action);

        return actionService.insert(action);
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
        System.out.println("=============");
        System.out.println(action.toString());

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
        System.out.println("update=============" + action);
        System.out.println(action.toString());

        return actionService.update(action);
    }

    /**
     * 删除
     *
     * @param action
     * @throws Exception
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(Action action) {
        System.out.println("=============");
        System.out.println(action.toString());

        return actionService.deleteByStr(action.getCode());

    }


}
