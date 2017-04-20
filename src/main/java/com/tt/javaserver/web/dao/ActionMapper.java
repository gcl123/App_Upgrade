package com.tt.javaserver.web.dao;

import com.tt.javaserver.web.vo.Action;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionMapper extends BaseMapper<Action> {

    void delete(String code);
}