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
}
