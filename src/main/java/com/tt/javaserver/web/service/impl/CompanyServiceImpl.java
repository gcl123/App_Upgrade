package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.CompanyService;
import com.tt.javaserver.web.vo.Company;
import com.tt.javaserver.web.vo.Page;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GCL on 17/4/17.
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {



    @Override
    public SimpleResult<Map> insert(Company company) {
        addCreateTime(company);
        addUpdateTime(company);
        if (company == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (companyMapper.selectRecord(company) == 0) {
            if (companyMapper.insert(company) == 1) {
                SimpleResult<Map> result = new SimpleResult<>(0, "插入成功");
                Map<String, Object> data = new HashMap<>();
                data.put("code", company.getId());
                result.setData(data);
                return result;
            }
        }
        return new SimpleResult(-1, "插入失败");
    }

    @Override
    public SimpleResult<Map> deleteByInt(int id) {

        if (id == 0) {
            return new SimpleResult(-2, "数据为空");
        }
        if (companyMapper.deleteByInt(id) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }

    @Override
    public SimpleResult update(Company company) {
        addUpdateTime(company);
        if (company == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (companyMapper.update(company) == 1) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    @Override
    public Object queryList() {
       return companyMapper.queryList();
    }

    @Override
    public Map selectPageUseDyc(Page<Company> page) {
        page.setList(companyMapper.selectPageListUseDyc(page));
        page.setTotalRecord(companyMapper.selectPageCountUseDyc(page));

        System.out.println("page========" + page.getPageMap());

        return page.getPageMap();
    }


    /**
     * 设置更新时间
     *
     * @param company
     */
    public void addUpdateTime(Company company) {
        company.setUpdateTime(getCurrentTime());
    }

    /**
     * 设置创建时间
     *
     * @param company
     */
    public void addCreateTime(Company company) {
        company.setCreateTime(getCurrentTime());
    }


}
