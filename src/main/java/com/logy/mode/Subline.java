package com.logy.mode;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *    支系实体类
 *
 * @author xky
 * @date 2019/3/10 14:14
 * @param
 * @return
 */

public class Subline implements Serializable {
    private Integer subID;
    private Integer subFamilyID;
    private String subName;
    private String subGelogy;
    private String subFamily;
    private String subCreateDate;
    private String subCode;
    private String subAddress;

    public Integer getSubID() {
        return subID;
    }

    public void setSubID(Integer subID) {
        this.subID = subID;
    }

    public Integer getSubFamilyID() {
        return subFamilyID;
    }

    public void setSubFamilyID(Integer subFamilyID) {
        this.subFamilyID = subFamilyID;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubGelogy() {
        return subGelogy;
    }

    public void setSubGelogy(String subGelogy) {
        this.subGelogy = subGelogy;
    }

    public String getSubFamily() {
        return subFamily;
    }

    public void setSubFamily(String subFamily) {
        this.subFamily = subFamily;
    }

    public String getSubCreateDate() {
        return subCreateDate;
    }

    public void setSubCreateDate(String subCreateDate) {
        this.subCreateDate = subCreateDate;
    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubAddress() {
        return subAddress;
    }

    public void setSubAddress(String subAddress) {
        this.subAddress = subAddress;
    }
}
