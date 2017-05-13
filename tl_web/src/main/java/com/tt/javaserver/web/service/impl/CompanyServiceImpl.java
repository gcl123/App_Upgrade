package com.tt.javaserver.web.service.impl;

import com.tt.javaserver.web.service.CompanyService;
import com.tt.javaserver.web.vo.Company;
import com.tt.javaserver.web.vo.CompanySelect;
import com.tt.javaserver.web.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by GCL on 17/4/17.
 */
@Service
public class CompanyServiceImpl extends BaseServiceImpl<Company> implements CompanyService {


    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceImpl.class);


    @Override
    public int insert(Company company) {
        addCreateTime(company);
        addUpdateTime(company);
        int r = 0;
        try {
            if(companyMapper.selectRecord(company)==0){
                return companyMapper.insert(company);
            }
            return -2;
        }catch (Exception e){
            e.printStackTrace();
            return r;
        }
    }

    @Override
    public int deleteByInt(int id) {

        int r = 0;
        try {
            return companyMapper.deleteByInt(id);
        }catch (Exception e){
            e.printStackTrace();
            return r;
        }
    }

    @Override
    public int update(Company company) {
        addUpdateTime(company);

        int r = 0;
        try {
            return companyMapper.update(company);
        }catch (Exception e){
            e.printStackTrace();
            return r;
        }
    }

    @Override
    public Object queryList() {
       return companyMapper.queryList();
    }

    /**
     * 公司下拉列表显示
     * @param request
     */
    @Override
    public void setCompany2session(HttpServletRequest request) {

        LOGGER.info("setCompany2session");
        List<Company> companyList = companyMapper.select();
        List<Object> coms = new ArrayList<>();

        Iterator it = companyList.iterator();
        while (it.hasNext()){
            Company company = (Company) it.next();
            CompanySelect companySelect = new CompanySelect();
            companySelect.setId(company.getId());
            companySelect.setName(company.getName());
            companySelect.setShortName(company.getShortName());
            coms.add(companySelect);
        }


        request.getSession().setAttribute("companyParams",coms);

    }


    /**
     * 分页查询
     * @param page
     * @return
     */
    @Override
    public Map selectPageUseDyc(Page<Company> page) {
        page.setList(companyMapper.selectPageListUseDyc(page));
        page.setTotalRecord(companyMapper.selectPageCountUseDyc(page));

        System.out.println("page========" + page.getPageMap());

        return page.getPageMap();
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
