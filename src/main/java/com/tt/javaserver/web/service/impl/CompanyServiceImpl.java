package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.CompanyService;
import com.tt.javaserver.web.vo.Company;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
    public SimpleResult<Map> deleteByStr(String code) {

        if (code == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (companyMapper.deleteByStr(code) == 1) {
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
    public SimpleResult select(Company company) {
        if (company == null) {
            return new SimpleResult(-2, "数据为空");
        }
        int total = companyMapper.selectCount(company);
        List<Company> companyList = companyMapper.selectList(company);

        if (total > 0 && companyList != null) {
            return new SimpleResult(0, "查询成功", total, "companys", companyList);
        }
        return new SimpleResult(-1, "查询失败");
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
