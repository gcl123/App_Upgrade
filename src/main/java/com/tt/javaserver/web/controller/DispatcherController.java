package com.tt.javaserver.web.controller;

import com.tt.javaserver.web.annotation.ZZWxJSSDK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by feng on 13/7/15.
 */
@Controller
@RequestMapping("/")
public class DispatcherController {

    private static Logger LOGGER = LoggerFactory.getLogger(DispatcherController.class);
    ;

    @RequestMapping(value = "test")
    public
    @ResponseBody
    void test(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        response.getWriter().println("Welcome,Tonlan!");
    }

    @ZZWxJSSDK
    @RequestMapping(value = "**")
    public ModelAndView index(
            @RequestParam(required = false, defaultValue = "false") boolean
                    refresh,
            @RequestParam(value = "promocode", required
                    = false, defaultValue
                    = "") String promoCode,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView view = new ModelAndView("/index");

        Map<String, Object> jsGlobal = new HashMap<String, Object>();

        return view;
    }

//    @RequestMapping(value = "healthcheck")
//    public
//    @ResponseBody
//    SimpleResult<Map> healthcheck(
//            HttpServletRequest request,
//            HttpServletResponse response) throws Exception {
//        SimpleResult<Map> ret = new SimpleResult<Map>(ResultCode.OK.getCode());
//        Map<String, String> data = new HashMap<String, String>();
//        data.put("status", "ok");
//        ret.setData(data);
//        return ret;
//    }


}
