package com.logy.form;

import lombok.Getter;
import lombok.Setter;

public class NewsForm {
    @Setter
    @Getter
    private Long newsID;

    @Setter
    @Getter
    private String newsTitle;

    @Setter
    @Getter
    private String newsContent;

    @Setter
    @Getter
    private String newsTime;

    @Setter
    @Getter
    private Long newsFamilyID;

    @Setter
    @Getter
    private Integer newsType;

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
