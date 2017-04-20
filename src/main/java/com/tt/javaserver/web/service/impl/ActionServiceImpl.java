package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.ActionService;
import com.tt.javaserver.web.vo.Action;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class ActionServiceImpl extends BaseServiceImpl<Action> implements ActionService {


    @Override
    public void delete(String code) {
        actionMapper.delete(code);
    }

    public int insert(Action action) {
        return actionMapper.insert(action);
    }

    @Override
    public List<Action> selectList(Action entity) {
        return actionMapper.selectListUseDyc(entity);
    }

    @Override
    public int selectCount(Action entity) {
        return actionMapper.selectCountUserDyc(entity);
    }

    @Override
    public int update(Action entity) {
        return actionMapper.update(entity);
    }
}
