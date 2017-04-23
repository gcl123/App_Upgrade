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

        System.out.print("company===add===" + company);
        addCreateTime(company);
        addUpdateTime(company);
        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();
        int flag = 0;
        try {
            flag = companyService.insert(company);
            LOGGER.warn("插入失败");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setResult(result, flag);
        data.put("id", companyService.getID(company));

        result.setData(data);
//        System.out.println("add ++ result===="+result);
        return result;
    }

    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(Company company) {
        System.out.print("company-query======" + company);


        int total = companyService.selectCount(company);
        List<Company> companyList = companyService.selectList(company);

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();

        setResult(result, total);

        data.put("total", total);
        data.put("companys", companyList);
        result.setData(data);

        return result;
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

        addUpdateTime(company);

        int i = companyService.update(company);
        SimpleResult<Map> result = new SimpleResult<>();

        setResult(result, i);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public SimpleResult<Map> delete(Company company) {
        System.out.println("delete=========" + company);
        int i = 0;
        i = companyService.delete(company);
        SimpleResult<Map> result = new SimpleResult<>();

        setResult(result, i);

        return result;
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
