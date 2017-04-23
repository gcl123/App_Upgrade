package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.ActionService;
import com.tt.javaserver.web.vo.Action;
import org.springframework.stereotype.Service;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class ActionServiceImpl extends BaseServiceImpl<Action> implements ActionService {




    @Override
    public int delete(Action action) {
        return actionMapper.deleteByStr(action.getCode());
    }
}
