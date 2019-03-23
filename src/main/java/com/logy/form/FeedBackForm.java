package com.logy.form;


import lombok.Getter;
import lombok.Setter;

public class FeedBackForm {
    @Setter
    @Getter
    private Long fbID;

    @Getter
    @Setter
    private Long fbmemberID;

    @Setter
    @Getter
    private String fbQuestion;

    @Setter
    @Getter
    private String fbAnswer;

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
