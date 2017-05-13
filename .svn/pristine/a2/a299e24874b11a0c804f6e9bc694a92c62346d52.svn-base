package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.ActionService;
import com.tt.javaserver.web.vo.Action;
import com.tt.javaserver.web.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class ActionServiceImpl extends BaseServiceImpl<Action> implements ActionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActionServiceImpl.class);




    @Override
    public int insert(Action action) {
        addCreateTime(action);
        addUpdateTime(action);

        int r = 0;
        try {
            if(actionMapper.selectRecord(action)==0){
                return  actionMapper.insert(action);
            }
            return -2;
        }catch (Exception e){
            return r;
        }
    }

    @Override
    public int deleteByStr(String code) {

        int r = 0;
        try {
            return  actionMapper.deleteByStr(code);
        }catch (Exception e){
            return r;
        }
    }

    @Override
    public int update(Action action) {
        addUpdateTime(action);
        int r = 0;
        try {
            return  actionMapper.update(action);
        }catch (Exception e){
            return r;
        }
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
     * 分页显示
     * @param page
     * @param
     * @return
     */
    @Override
    public Map selectPageUseDyc(Page<Action> page) {
        List<Action> appList = actionMapper.selectPageListUseDyc(page);
        int total = actionMapper.selectPageCountUseDyc(page);
        page.setList(appList);
        page.setTotalRecord(total);

        return page.getPageMap();
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
