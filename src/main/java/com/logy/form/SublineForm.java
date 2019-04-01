package com.logy.form;

import lombok.Getter;
import lombok.Setter;

/**
 * 支系信息Bean类
 */

public class SublineForm {
    @Setter
    @Getter
    private String subName;

    @Setter
    @Getter
    private String subGelogy;

    @Setter
    @Getter
    private Integer subFamilyID;

    @Setter
    @Getter
    private Integer sublineID;

    @Setter
    @Getter
    private String subAddress;

    private Integer page;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = (page - 1) * limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
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

    public Integer getSubFamilyID() {
        return subFamilyID;
    }

    public void setSubFamilyID(Integer subFamilyID) {
        this.subFamilyID = subFamilyID;
    }

    public Integer getSublineID() {
        return sublineID;
    }

    public void setSublineID(Integer sublineID) {
        this.sublineID = sublineID;
    }

    public String getSubAddress() {
        return subAddress;
    }

    public void setSubAddress(String subAddress) {
        this.subAddress = subAddress;
    }
}
