package com.tt.javaserver.web.util;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by GCL on 17/4/17.
 */
public class ReturnResult {


    /**
     * 向前端返回数据
     *
     * @param retcode
     * @param retmsg
     * @param dataMap
     * @return
     */
    public static Map retResult(int retcode, String retmsg, Map dataMap) {
        Map<String, Object> retMap = new HashedMap();
        retMap.put("retcode", retcode);
        retMap.put("retmsg", retmsg);
        retMap.put("data", dataMap);

        return retMap;
    }
}
