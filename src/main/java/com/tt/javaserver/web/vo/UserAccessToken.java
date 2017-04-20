package com.tt.javaserver.web.vo;

/**
 * Created by wzy on 2016-06-20.
 * 创建认证数据的实体，包括用户名称，签名数据，以及时间戳
 */
public class UserAccessToken {
    private String partnerId;
    private String sign;
    private String transno;

    public String getPartnerId() {
        return partnerId;
    }

    public String getSign() {
        return sign;
    }

    public String getTransno() {
        return transno;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setTransno(String timeStamp) {
        this.transno = timeStamp;
    }
}
