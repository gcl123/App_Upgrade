package com.tt.javaserver.web.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by flying on 11/28/15.
 */
public class TlRequestContext {

    private int uin;
    private long startTime;

    public static String currentServiceName = "";

    private Map<String, Object> params = new HashMap<String, Object>();

    private static final ThreadLocal<TlRequestContext> THREAD_LOCAL = new
            ThreadLocal<TlRequestContext>();

    public static void init() {
        TlRequestContext ctx = new TlRequestContext();
        ctx.startTime = System.currentTimeMillis();
        THREAD_LOCAL.set(ctx);
    }

    public static void destroy() {
        THREAD_LOCAL.remove();
    }

    public static void setUin(int uin) {
        TlRequestContext ctx = THREAD_LOCAL.get();
        if (ctx != null) {
            ctx.uin = uin;
        }
    }

    public static int getUin() {
        TlRequestContext ctx = THREAD_LOCAL.get();
        if (ctx != null) {
            return ctx.uin;
        }
        return 0;
    }

    public static Object get(String param) {
        return THREAD_LOCAL.get().params.get(param);
    }

    public static void remove(String param) {
        THREAD_LOCAL.get().params.remove(param);
    }

    public static void set(String param, Object value) {
        THREAD_LOCAL.get().params.put(param, value);
    }

    public static long getStartTime() {
        return THREAD_LOCAL.get().startTime;
    }
}
