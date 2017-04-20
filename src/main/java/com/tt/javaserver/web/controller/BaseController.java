package com.tt.javaserver.web.controller;

import com.google.gson.Gson;
import com.tt.javaserver.web.model.ResultCode;
import com.tt.javaserver.web.model.SimpleResult;
import org.springframework.stereotype.Controller;

import java.util.Map;

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

    /**
     * 设置返回结果
     *
     * @param result
     * @param i      操作返回的结果 成功返回1
     */
    public void setResult(SimpleResult<Map> result, int i) {
        if (i > 0) {
            result.setCode(ResultCode.OK.getCode());
            result.setMsg(ResultCode.OK.getMsg());
        } else {
            result.setCode(ResultCode.ERROR.getCode());
            result.setMsg(ResultCode.ERROR.getMsg());
        }
    }


}
