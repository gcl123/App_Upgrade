package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.model.ResultCode;
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

        System.out.print("====company" + company);
        addCreateTime(company);
        addUpdateTime(company);
        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();
        int flag = 0;
        try {
            flag = companyService.insert(company);
            LOGGER.warn("插入失败");

            LOGGER.error("method[{}] error:  {}");
        } catch (Exception e) {
            flag = -1;
            e.printStackTrace();
        }
        if (flag > 0) {
            result.setCode(ResultCode.OK.getCode());
            result.setMsg(ResultCode.OK.getMsg());
            try {
                data.put("id", companyService.getID(company));
            } catch (Exception e) {
                data.put("id", null);
                e.printStackTrace();
            }
        } else {
            result.setCode(ResultCode.ERROR.getCode());
            result.setMsg(ResultCode.ERROR.getMsg());
        }
        result.setData(data);

        return result;
    }

    @RequestMapping("/query")
    @ResponseBody
    public SimpleResult<Map> query(Company company) {
        System.out.print("====company" + company);


        int total = companyService.selectCount(company);
        List<Company> companyList = companyService.selectList(company);

        SimpleResult<Map> result = new SimpleResult<>();
        Map<String, Object> data = new HashMap<>();

        if (total > 0 && companyList != null) {
            result.setCode(ResultCode.OK.getCode());
            result.setMsg(ResultCode.OK.getMsg());
        } else {
            result.setCode(ResultCode.ERROR.getCode());
            result.setMsg(ResultCode.ERROR.getMsg());
        }
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
    public SimpleResult<Map> update(Company company) {
        System.out.println("=========" + company);

        addUpdateTime(company);
        try {
            company.setId(companyService.getID(company));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int i = companyService.update(company);
        SimpleResult<Map> result = new SimpleResult<>();
        if (i > 0) {
            result.setCode(ResultCode.OK.getCode());
            result.setMsg(ResultCode.OK.getMsg());
        } else {
            result.setCode(ResultCode.ERROR.getCode());
            result.setMsg(ResultCode.ERROR.getMsg());
        }
        return result;
    }

    @RequestMapping("/delete")
    public void delete(Company company) {
        System.out.println("=========" + company);
        int id = 0;
        try {
            id = companyService.getID(company);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(id);
        try {
            companyService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
