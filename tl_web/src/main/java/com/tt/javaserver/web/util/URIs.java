package com.tt.javaserver.web.util;

import org.apache.commons.lang3.StringUtils;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by feng on 12/14/15.
 */
public class URIs {

    public static String renderURI(String prefixUrl, String path) throws
            Exception {
        if (StringUtils.isEmpty(prefixUrl) || StringUtils.isEmpty(path)) {
            throw new Exception();
        }
        return (prefixUrl.endsWith("/") ? prefixUrl : prefixUrl + "/") + path;
    }

    public static String getIp(HttpServletRequest request) {
        String ip = null;
        String realIp = request.getHeader("X-Real-IP");// nginx
        if (StringUtils.isNotBlank(realIp) && !internalIp(realIp)) {
            ip = realIp;
        }
        if (null == ip || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            String xForwaredIp = request.getHeader("X-Forwarded-For");
            if (StringUtils.isNotBlank(xForwaredIp) && !internalIp
                    (xForwaredIp)) {
                ip = xForwaredIp;
            }
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        try {
            ip = ip.split(",")[0];
        } catch (Exception e) {
            ip = request.getRemoteHost();
        }
        return ip;
    }

    public static boolean internalIp(String ip) {
        if (StringUtils.isBlank(ip)) {
            return false;
        }
        if (ip.equalsIgnoreCase("localhost") || ip.equals("127.0.0.1")) {
            return true;
        }
        byte[] addr = IPAddressUtil.textToNumericFormatV4(ip);
        final byte b0 = addr[0];
        final byte b1 = addr[1];
        // 10.x.x.x/8
        final byte SECTION_1 = 0x0A;
        // 172.16.x.x/12
        final byte SECTION_2 = (byte) 0xAC;
        final byte SECTION_3 = (byte) 0x10;
        final byte SECTION_4 = (byte) 0x1F;
        // 192.168.x.x/16
        final byte SECTION_5 = (byte) 0xC0;
        final byte SECTION_6 = (byte) 0xA8;
        switch (b0) {
            case SECTION_1:
                return true;
            case SECTION_2:
                if (b1 >= SECTION_3 && b1 <= SECTION_4) {
                    return true;
                }
            case SECTION_5:
                switch (b1) {
                    case SECTION_6:
                        return true;
                }
            default:
                return false;
        }
    }

}
