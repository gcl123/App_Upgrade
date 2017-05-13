package com.tt.javaserver.web.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;

/**
 * Created by GCL on 17/4/18.
 */
@Controller
public class BaseController {

    /**
     * java 对象转换成json字符串
     *
     * @param object
     * @return
     */
    public String java2Json(Object object) {
        Gson gson = new Gson();
        String jsonResult = gson.toJson(object);
        System.out.println("json::::" + jsonResult);

        return jsonResult;
    }


}
