package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.util.XMLUtils;
import com.tt.javaserver.web.vo.CompanySelect;

/**
 * Created by GCL on 17/5/11.
 */

public class scriptController {

    public static void main(String[] args) {
        // 创建需要转换的对象
        CompanySelect companySelect = new CompanySelect(1, "hello", "GAO");
//        System.out.println("---将对象转换成string类型的xml Start---");
//        // 将对象转换成string类型的xml
//        String str = XMLUtils.convertToXml(companySelect);
//        // 输出
//        System.out.println(str);
//        System.out.println("---将对象转换成string类型的xml End---");
//        System.out.println();
//        System.out.println("---将String类型的xml转换成对象 Start---");
//        CompanySelect c = (CompanySelect) XMLUtils.convertXmlStrToObject(CompanySelect.class, str);
//        System.out.println(c);
//        System.out.println("---将String类型的xml转换成对象 End---");


//将xml生成到指定目录/Users/apple/IDEA/upload";
        String path = "/Users/apple/IDEA/upload/company.xml";
        System.out.println("---将对象转换成File类型的xml Start---");
        XMLUtils.convertToXml(companySelect, path);
        System.out.println("---将对象转换成File类型的xml End---");
        System.out.println();
        System.out.println("---将File类型的xml转换成对象 Start---");
        CompanySelect c = (CompanySelect) XMLUtils.convertXmlFileToObject(CompanySelect.class, path);
        System.out.println(c);
        System.out.println("---将File类型的xml转换成对象 End---");
    }
}
