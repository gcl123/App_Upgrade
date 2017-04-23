package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.ActionService;
import com.tt.javaserver.web.vo.Action;
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
@RequestMapping("/action")
public class ActionController extends BaseController {
    @Resource
    private ActionService actionService;

    /**
     * 新增操作指令
     */
    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(Action action) {
        System.out.println("====add====");
        System.out.println(action.toString());

        addCreateTime(action);
        addUpdateTime(action);

        int i = 0;
        try {
            i = actionService.insert(action);
        } catch (Exception e) {
            i = 0;
            e.printStackTrace();
        }

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();

        setResult(result,i);
        data.put("code", action.getCode());
        result.setData(data);

        System.out.println(result);

        return result;

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
        System.out.println("=============query");
        System.out.println(action.toString());

        int total = actionService.selectCount(action);
        List<Action> actionList = actionService.selectList(action);

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();

        setResult(result,total);
        data.put("total", total);
        data.put("actions", actionList);
        result.setData(data);
        return result;
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
        System.out.println("=============");
        System.out.println(action);
        addUpdateTime(action);
        int i = actionService.update(action);
        SimpleResult<Map> result = new SimpleResult<>();

        setResult(result,i);
        System.out.println(result);

        return result;


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

        String code = action.getCode();
        actionService.delete(action);
        int i = actionService.update(action);
        SimpleResult<Map> result = new SimpleResult<>();

        setResult(result,i);

        return result;
    }

    /**
     * 设置更新时间
     *
     * @param action
     */
    public void addUpdateTime(Action action) {
        action.setUpdateTime(getCurrentTime());
    }

    /**
     * 设置创建时间
     *
     * @param action
     */
    public void addCreateTime(Action action) {
        action.setCreateTime(getCurrentTime());
    }


}
