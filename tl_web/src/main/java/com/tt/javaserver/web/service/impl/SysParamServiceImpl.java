package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.SysParamService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SysParamServiceImpl extends BaseServiceImpl implements SysParamService {


    @Override
    public Map<String, Object> selectList() {

//        System.out.println("=====系统参数====");
//        List<Company> appList = companyMapper.select();
//        Map<String, Object> sysCompany = new HashMap<>();
//        Iterator it = appList.iterator();
//        while (it.hasNext()) {
//            Company company = (Company) it.next();
//            sysCompany.put(company.getName(), company.getId());
//        }
//
//
        Map<String ,Object> companyParams = new HashMap<>();
//        companyParams.put("companyParams",sysCompany);

        //System.out.println(sys);
        return companyParams;
    }


}
