package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.CompanyService;
import com.tt.javaserver.web.vo.Company;
import org.springframework.stereotype.Service;

/**
 * Created by GCL on 17/4/17.
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {


    @Override
    public int insert(Company company) throws Exception {
        int Total = companyMapper.selectRecord(company);
        System.out.println("total=====" + Total);
        if (Total != 0) {
            return -1;
        }
        return companyMapper.insert(company);

    }


    @Override
    public int delete(Company company) {
        return companyMapper.deleteByStr(company.getCode());
    }
}
