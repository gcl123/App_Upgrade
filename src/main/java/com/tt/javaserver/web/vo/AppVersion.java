package com.tt.javaserver.web.vo;

public class AppVersion {

    private Integer id;

    private Integer appId;

    private String version;

    private Integer status;

    private String updateDescription;

    private String setupScript;

    private String var1;

    private String var2;

    private String var3;

    private String var4;

    private String var5;

    private Long updateTime;

    private Long createTime;

    private String remark;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUpdateDescription() {
        return updateDescription;
    }

    public void setUpdateDescription(String updateDescription) {
        this.updateDescription = updateDescription;
    }

    public String getSetupScript() {
        return setupScript;
    }

    public void setSetupScript(String setupScript) {
        this.setupScript = setupScript;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public String getVar4() {
        return var4;
    }

    public void setVar4(String var4) {
        this.var4 = var4;
    }

    public String getVar5() {
        return var5;
    }

    public void setVar5(String var5) {
        this.var5 = var5;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AppVersion{" +
                "id=" + id +
                ", appId=" + appId +
                ", version='" + version + '\'' +
                ", status=" + status +
                ", updateDescription='" + updateDescription + '\'' +
                ", setupScript='" + setupScript + '\'' +
                ", var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                ", var3='" + var3 + '\'' +
                ", var4='" + var4 + '\'' +
                ", var5='" + var5 + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                '}';
    }
}