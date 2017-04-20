package com.tt.javaserver.web.controller;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;

/**
 * Created by GCL on 17/4/18.
 */
@Controller
public class BaseController {
    /**
     * 获得当前时间
     *
     * @return
     */
    public long getCurrentTime() {
        long time = System.currentTimeMillis();


//        SimpleDateFormat sdFormatter = new SimpleDateFormat("yyyyMMddHHmmss");
//        String StrFormatNowDate = sdFormatter.format(ct);
//        long time = Long.parseLong(StrFormatNowDate);
        return time;
    }

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
