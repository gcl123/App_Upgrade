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
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
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

        LOGGER.info("add======" + company);

        if (company == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (companyService.insert(company) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "插入公司成功");
            Map<String, Object> data = new HashMap<>();
            data.put("id", company.getId());
            result.setData(data);
            return result;
        }
        return new SimpleResult(-1, "插入失败");
    }

    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(Company company) {
        LOGGER.info("company-query======" + company);

        if (company == null) {
            return new SimpleResult(-2, "数据为空");
        }
        int total = companyService.selectTotal(company);
        List<Company> companyList = companyService.selectList(company);
        if (total > 0 || companyList != null) {
            SimpleResult<Map> result = new SimpleResult<>(0, "查询公司成功");
            Map<String, Object> data = new HashMap<>();
            data.put("total", total);
            data.put("companys",companyList);
            result.setData(data);
            return result;
        }
        return new SimpleResult(-1, "插入失败");
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
        LOGGER.info("update=========" + company);

        if (company == null) {
            return new SimpleResult(-2, "数据为空");
        }
        if (companyService.update(company) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "更新成功");
            return result;
        }
        return new SimpleResult(-1, "更新失败");
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(Integer id) {
        LOGGER.info("delete=========" + id);

        if (id == 0) {
            return new SimpleResult(-2, "数据为空");
        }
        if (companyService.deleteByInt(id) > 0) {
            SimpleResult<Map> result = new SimpleResult<>(0, "删除成功");
            return result;
        }
        return new SimpleResult(-1, "删除失败");
    }

    /**
     * 通过关键字分页查询 并将公司信息存入session
     * @param page
     * @param request
     * @return
     */
    @RequestMapping("/selectPageUseDyc")
    @ResponseBody
    public Object selectPageUseDyc(Page<Company> page, HttpServletRequest request) {

        LOGGER.info("page==========:" + page );
        companyService.setCompany2session(request);
        return companyService.selectPageUseDyc(page);
    }




}
