package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.CompanyService;
import com.tt.javaserver.web.vo.Company;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GCL on 17/4/17.
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {


    @Override
    public int insert(Company entity) throws Exception {
        int appTotal = companyMapper.selectByCode(entity.getCode());
        if (appTotal < 1) {
            return companyMapper.insert(entity);
        }
        return -1;
    }

    @Override
    public int update(Company entity) {
        return companyMapper.update(entity);
    }

    @Override
    public int delete(int id) throws Exception {
        return companyMapper.delete(id);
    }


    @Override
    public int deleteList(String[] pks) throws Exception {
        return companyMapper.deleteList(pks);
    }

    @Override
    public Company select(Company entity) {
        return companyMapper.select(entity);
    }

    @Override
    public List<Company> selectList(Company entity) {
        return companyMapper.selectListUseDyc(entity);
    }

    @Override
    public int selectCount(Company entity) {
        System.out.println("base............." + entity);
        return companyMapper.selectCountUserDyc(entity);
    }

    @Override
    public int getID(Company entity) throws Exception {
        return companyMapper.selectID(entity);
    }

}
