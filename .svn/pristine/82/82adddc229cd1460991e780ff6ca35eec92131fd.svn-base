package com.tt.javaserver.web.web.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;

/**
 * Created by flying on 11/21/15.
 */
@Service
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class UserProfileServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserProfileServiceTest.class);

    //    @Resource
//    private UserMapper userMapper;
//
////    @Resource
////    private CompanyMapper companyMapper;
//    @Resource
//    private ActionMapper actionMapper;
//
//    @Resource
//    private AppMapper appMapper;
//
//
//    @Test
//    public void add(){
//        User user = new User();
//        user.setId(1);
//        user.setUserName("hello");
//
//     int  i =    userMapper.add(user);
//
//        if(i != 0 ){
//            System.out.print("success");
//
//        }
//        System.out.print("=======");
//
//
//    }
//
////    @Test
////    public void testCom(){
////        Company company = new Company();
////        company.setId(1);
////        company.setCode("1001");
////        company.setName("hello");
////
////        int  i =   companyMapper.insert(company);
////
////        if(i != 0 ){
////            System.out.print("success");
////
////        }
////        System.out.print("=======");
////
////
////    }
//
//    @Test
//    public void testAction(){
//        Action action = new Action();
//
//        action.setCode("10");
////       action.setName("hello");
////        action.setCreateTime(2017);
////        action.setVaild(0);
//
////        int i = actionMapper.insert(action);
//        int i = 0;
////        i = actionMapper.delete("1002");
////
////        List<Action> list = actionMapper.selectListUseDyc(action);
////
////        System.out.print("list"+list);
////        i = actionMapper.query(action);
////        System.out.print("IIIIIII"+i);
//
//        Action action1 = actionMapper.select(action);
//        System.out.println("action"+action1);
//
//
//        if(i!=0){
//            System.out.print("success");
//        }
//
//        System.out.print("===========");
//    }
//
//
//    @Test
//    public void testApp(){
//        App app = new App();
////        app.setId(2);
//        app.setAppCode("300");
//        app.setAppName("xxxx");
//        app.setLatestVersion("1.0");
//        app.setLimitVersion("1.0");
//        app.setDescription("=====");
//        app.setCompanyId(11);
//// 插入当前时间
//
////        long ct = System.currentTimeMillis();
////
////        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
////        String StrFormatNowDate = sdFormatter.format(ct);
////
////        long time = Long.parseLong(StrFormatNowDate);
////
////
////        app.setCreateTime(time);
//
//
//
//
//
//
//         int i =0;
//         i = appMapper.insert(app);
//
////        int i = appMapper.delete(String.valueOf(1));
//
////        int i = appMapper.update(app);
////
////        List<App> list = appMapper.selectListUseDyc(app);
////        System.out.println(list);
////
////        i = appMapper.selectCountUserDyc(app);
//
////        i = appMapper.selectID(app);
//
//        if(i!=0){
//            System.out.print("success------"+i);
//        }
//
//        System.out.print("===========");
//    }
//
//
    @Test
    public void getTime() {

//        String t = String.valueOf(ct);
//        System.out.println(t);
//
//        Date nowTime = new Date(System.currentTimeMillis());
//
        LOGGER.error("--------------------");

        try {
            int i = 1 / 0;

        } catch (Exception e) {
            LOGGER.error("error", e);

            System.out.println("errot" + e.getMessage());
        }

        long ct = System.currentTimeMillis();
        System.out.println(ct);
        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String StrFormatNowDate = sdFormatter.format(ct);
        System.out.println(StrFormatNowDate + "=====");

//        20170413234150
//        Date date = new Date(ct);
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
//        System.out.println(df.format(date));// new Date()为获取当前系统时间

//        String date2 = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
//                .format(new java.util.Date(1434031896*1000L));
//

    }
//


}