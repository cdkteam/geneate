package com.logy.form;


import lombok.Getter;
import lombok.Setter;

/**
 * 消息反馈Bean类
 */

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

    public Long getFbID() {
        return fbID;
    }

    public void setFbID(Long fbID) {
        this.fbID = fbID;
    }

    public Long getFbmemberID() {
        return fbmemberID;
    }

    public void setFbmemberID(Long fbmemberID) {
        this.fbmemberID = fbmemberID;
    }

    public String getFbQuestion() {
        return fbQuestion;
    }

    public void setFbQuestion(String fbQuestion) {
        this.fbQuestion = fbQuestion;
    }

    public String getFbAnswer() {
        return fbAnswer;
    }

    public void setFbAnswer(String fbAnswer) {
        this.fbAnswer = fbAnswer;
    }
}
