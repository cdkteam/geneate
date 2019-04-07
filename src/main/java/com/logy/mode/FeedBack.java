package com.logy.mode;



/**
 *    反馈实体类
 *
 * @author xky
 * @date 2019/3/21 11:20
 * @param
 * @return
 */

public class FeedBack {
    private Long fbID;
    private Long fbmemberID;
    private String fbQuestion;
    private String fbAnswer;

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
