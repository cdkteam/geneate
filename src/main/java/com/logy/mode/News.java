package com.logy.mode;



/**
 *
 *   帖子类
 * @author xky
 * @date 2019/3/21 22:13  
 * @param   
 * @return   
 */


public class News {
    private Long newsID;
    private String newsTitle;
    private String newsContent;
    private String newsTime;
    private Long newsFamilyID;
    private Integer newsType;
    private String createUser;
    private String familyName;

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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
