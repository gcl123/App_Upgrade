package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.CompanyService;
import com.tt.javaserver.web.vo.Company;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by GCL on 17/4/15.
 */

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Resource
    private CompanyService companyService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @RequestMapping("/add")
    @ResponseBody
    public SimpleResult<Map> insert(Company company) {

        System.out.print("company===add===" + company);

        return companyService.insert(company);
    }

    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(Company company) {
        System.out.print("company-query======" + company);

        return companyService.select(company);
    }

    /**
     * 更新公司信息
     *
     * @param company
     * @throws Exception
     */
    @RequestMapping("/update")
    @ResponseBody
    public SimpleResult<Map> update(Company company) {
        System.out.println("update=========" + company);

        return companyService.update(company);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(Company company) {
        System.out.println("delete=========" + company);

        return companyService.deleteByStr(company.getCode());

    }

}
