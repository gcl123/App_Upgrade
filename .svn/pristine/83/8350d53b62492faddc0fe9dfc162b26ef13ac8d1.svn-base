package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.SimpleResult;
import com.tt.javaserver.web.service.CompanyService;
import com.tt.javaserver.web.vo.Company;
import com.tt.javaserver.web.vo.Page;
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

    @RequestMapping("/search")
    @ResponseBody
    public SimpleResult<Map> query(Company company) {
        System.out.print("company-search======" + company);

        return companyService.select(company);
    }

    @RequestMapping("/queryList")
    @ResponseBody
    public Object queryList() {
        System.out.print("company-queryList======" );
        return companyService.queryList();
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
    public Object delete(Integer id) {
        System.out.println("delete=========" + id);

        return companyService.deleteByInt(id);
    }

    //通过关键字分页查询
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
    public Object selectPageUseDyc(Page<Company> page, Company company) {

        company.setName(" ");
        page.setParamEntity(company);
        System.out.println("page==========:" + page + "=======" + company);

        return companyService.selectPageUseDyc(page);
    }

}
