package com.tt.javaserver.web.vo;

public class AppVersion {

    private Integer id;

    private Integer appId;

    private String version;

    private Integer status;

    private String statusInfo;

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

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppVersion that = (AppVersion) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (statusInfo != null ? !statusInfo.equals(that.statusInfo) : that.statusInfo != null) return false;
        if (updateDescription != null ? !updateDescription.equals(that.updateDescription) : that.updateDescription != null)
            return false;
        if (setupScript != null ? !setupScript.equals(that.setupScript) : that.setupScript != null) return false;
        if (var1 != null ? !var1.equals(that.var1) : that.var1 != null) return false;
        if (var2 != null ? !var2.equals(that.var2) : that.var2 != null) return false;
        if (var3 != null ? !var3.equals(that.var3) : that.var3 != null) return false;
        if (var4 != null ? !var4.equals(that.var4) : that.var4 != null) return false;
        if (var5 != null ? !var5.equals(that.var5) : that.var5 != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        return remark != null ? remark.equals(that.remark) : that.remark == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (statusInfo != null ? statusInfo.hashCode() : 0);
        result = 31 * result + (updateDescription != null ? updateDescription.hashCode() : 0);
        result = 31 * result + (setupScript != null ? setupScript.hashCode() : 0);
        result = 31 * result + (var1 != null ? var1.hashCode() : 0);
        result = 31 * result + (var2 != null ? var2.hashCode() : 0);
        result = 31 * result + (var3 != null ? var3.hashCode() : 0);
        result = 31 * result + (var4 != null ? var4.hashCode() : 0);
        result = 31 * result + (var5 != null ? var5.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        return result;
    }
}