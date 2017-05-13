package com.tt.javaserver.web.vo;

/**
 * Created by GCL on 17/5/10.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "CompanySelect")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "id",
        "name",
        "shortName",
})
public class CompanySelect implements Serializable {

    private int id;
    private String name;
    private String shortName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public CompanySelect() {
    }

    public CompanySelect(int id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "CompanySelect{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
