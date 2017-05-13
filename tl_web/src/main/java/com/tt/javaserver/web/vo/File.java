package com.tt.javaserver.web.vo;

public class File {
    private Integer id;

    private Integer appId;

    private String name;

    private String url;

    private Long size;

    private Integer type;

    private Integer gzip;

    private String version;

    private String var1;

    private String var2;

    private String var3;

    private String var4;

    private String var5;

    private Long updateTime;

    private Long createTime;

    private String remark;

    private String md5;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getGzip() {
        return gzip;
    }

    public void setGzip(Integer gzip) {
        this.gzip = gzip;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (id != null ? !id.equals(file.id) : file.id != null) return false;
        if (appId != null ? !appId.equals(file.appId) : file.appId != null) return false;
        if (name != null ? !name.equals(file.name) : file.name != null) return false;
        if (url != null ? !url.equals(file.url) : file.url != null) return false;
        if (size != null ? !size.equals(file.size) : file.size != null) return false;
        if (type != null ? !type.equals(file.type) : file.type != null) return false;
        if (gzip != null ? !gzip.equals(file.gzip) : file.gzip != null) return false;
        if (version != null ? !version.equals(file.version) : file.version != null) return false;
        if (var1 != null ? !var1.equals(file.var1) : file.var1 != null) return false;
        if (var2 != null ? !var2.equals(file.var2) : file.var2 != null) return false;
        if (var3 != null ? !var3.equals(file.var3) : file.var3 != null) return false;
        if (var4 != null ? !var4.equals(file.var4) : file.var4 != null) return false;
        if (var5 != null ? !var5.equals(file.var5) : file.var5 != null) return false;
        if (updateTime != null ? !updateTime.equals(file.updateTime) : file.updateTime != null) return false;
        if (createTime != null ? !createTime.equals(file.createTime) : file.createTime != null) return false;
        if (remark != null ? !remark.equals(file.remark) : file.remark != null) return false;
        return md5 != null ? md5.equals(file.md5) : file.md5 == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (gzip != null ? gzip.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (var1 != null ? var1.hashCode() : 0);
        result = 31 * result + (var2 != null ? var2.hashCode() : 0);
        result = 31 * result + (var3 != null ? var3.hashCode() : 0);
        result = 31 * result + (var4 != null ? var4.hashCode() : 0);
        result = 31 * result + (var5 != null ? var5.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (md5 != null ? md5.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", appId=" + appId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", size=" + size +
                ", type=" + type +
                ", gzip=" + gzip +
                ", version='" + version + '\'' +
                ", var1='" + var1 + '\'' +
                ", var2='" + var2 + '\'' +
                ", var3='" + var3 + '\'' +
                ", var4='" + var4 + '\'' +
                ", var5='" + var5 + '\'' +
                ", updateTime=" + updateTime +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                ", md5='" + md5 + '\'' +
                '}';


    }


}