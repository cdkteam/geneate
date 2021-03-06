package com.logy.form;



/**
 * 帖子消息Bean类
 */

public class NewsForm {

    private Long newsID;


    private String newsTitle;


    private String newsContent;

    private String newsTime;


    private Long newsFamilyID;


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


    public Long getNewsID() {
        return newsID;
    }

    public void setNewsID(Long newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public Long getNewsFamilyID() {
        return newsFamilyID;
    }

    public void setNewsFamilyID(Long newsFamilyID) {
        this.newsFamilyID = newsFamilyID;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }
}
