package com.tt.javaserver.web.controller;







//import com.tt.javaserver.web.service.SysParamService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import javax.servlet.ServletContext;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/sysParam")
//public class SysParamAction {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(SysParamAction.class);
//    @Resource
//    private SysParamService sysParamService;
//    @Resource
//    ServletContext application;
//
//
//    //后边可以用来重新加载参数
//    @RequestMapping(value = "/reload")
//    @ResponseBody
//    public void reloadSysParam() {
//        loadSysParam();
//    }
//
//    //系统启动时加载参数
//    @PostConstruct
//    public void initSysParam() {
//        loadSysParam();
//    }
//
//    //用来加载系统参数
//    public void loadSysParam() {
//        Map<String, Object> sysParamMap = sysParamService.selectList();
//
//        application.setAttribute("sysParam", sysParamMap);
//        application.setAttribute("hello", "hello");
//
//        LOGGER.info("===================系统参数加载成功2=====================");
//    }
//
//
//}
