package com.tt.javaserver.web.service;

import com.tt.javaserver.web.vo.Company;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by GCL on 17/4/15.
 */
@Service
public interface CompanyService extends BaseService<Company> {

    Object queryList();

    void setCompany2session(HttpServletRequest request);
}
