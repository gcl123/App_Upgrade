package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.ActionService;
import com.tt.javaserver.web.vo.Action;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class ActionServiceImpl extends BaseServiceImpl<Action> implements ActionService {




    @Override
    public SimpleResult<Map> insert(Action action) {
        addCreateTime(action);
        addUpdateTime(action);
        if (action == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (actionMapper.selectRecord(action) == 0) {
            if (actionMapper.insert(action) == 1) {
                SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
                Map<String, Object> data = new HashMap<>();
                data.put("code", action.getCode());
                result.setData(data);
                System.out.println("=======" + result);
                return result;
            }
        }
        return new SimpleResult(-1, "插入失败,指令已存在");
    }

    @Override
    public SimpleResult<Map> deleteByStr(String code) {

        if (code == null) {
            return new SimpleResult(-2, "数据为空");
        }

        if (actionMapper.deleteByStr(code) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            Map<String, Object> data = new HashMap<>();
            data.put("code", code);
            result.setData(data);
            System.out.println("=======" + result);
            return result;
        }

        return new SimpleResult(-1, "删除失败");
    }

    @Override
    public SimpleResult update(Action action) {
        addUpdateTime(action);
        if (action == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (actionMapper.update(action) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    @Override
    public SimpleResult select(Action action) {

        if (action == null) {
            return new SimpleResult(-2, "数据为空", 0, "actions", null);
        }
        int total = actionMapper.selectCount(action);
        List<Action> actionList = actionMapper.selectList(action);

        if (total > 0 && actionList != null) {
            return new SimpleResult(0, "查询成功", total, "actions", actionList);
        }
        return new SimpleResult(-1, "查询失败");
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
