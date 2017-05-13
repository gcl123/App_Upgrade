package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.AppService;
import com.tt.javaserver.web.vo.App;
import com.tt.javaserver.web.vo.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public class AppServiceImpl extends BaseServiceImpl<App> implements AppService {


    @Override
    public SimpleResult<Map> insert(App app) {
        addCreateTime(app);
        addUpdateTime(app);

        if (app == null) {
            return new SimpleResult(-2, "数据为空");
        }

        if (appMapper.selectRecord(app) == 0) {
            if (appMapper.insert(app) == 1) {
                SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
                Map<String, Object> data = new HashMap<>();
                data.put("code", app.getId());
                result.setData(data);
                System.out.println("insert=======" + result);
                return result;
            }
        }
        return new SimpleResult(-1, "插入失败,软件存在");
    }

    @Override
    public SimpleResult<Map> deleteByInt(int  id) {
        System.out.println("id=====before"+id);

        if (id == 0) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appMapper.deleteByInt(id) == 1) {
            System.out.println("id====="+id);
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            Map<String, Object> data = new HashMap<>();
            data.put("id", id);
            result.setData(data);
            System.out.println("del=======" + result);
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }

    public SimpleResult update(App app) {
        addUpdateTime(app);
        if (app == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (appMapper.update(app) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    @Override
    public SimpleResult select(App app) {
        if (app == null) {
            return new SimpleResult(-2, "数据为空", 0, "apps", null);
        }
        int total = appMapper.selectCount(app);
        List<App> appList = appMapper.selectList(app);

        if (total > 0 && appList != null) {
            return new SimpleResult(0, "查询成功", total, "apps", appList);
        }
        return new SimpleResult(-1, "查询失败");
    }


    @Override
    public Map selectPageUseDyc(Page<App> page) {
        page.setList(appMapper.selectPageListUseDyc(page));
        page.setTotalRecord(appMapper.selectPageCountUseDyc(page));

        System.out.println("page========" + page.getPageMap());

        return page.getPageMap();
    }


    /**
     * 设置更新时间
     *
     * @param app
     */
    public void addUpdateTime(App app) {
        app.setUpdateTime(getCurrentTime());
    }

    /**
     * 设置创建时间
     *
     * @param app
     */
    public void addCreateTime(App app) {
        app.setCreateTime(getCurrentTime());
    }


}
