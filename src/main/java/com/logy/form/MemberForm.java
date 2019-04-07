package com.logy.form;



import java.io.Serializable;

/**
 * 家庭成员Bean类
 */


public class MemberForm implements Serializable {
    private Integer memberID;
    private String memberName;
    private String memberPhone;
    private String memberIDNumber;
    private Integer memberFamilyID;
    private Integer sublineID;
    private Integer memberSex;
    private String memberNation;
    private String memberPass;

    private String newPass;

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

    public Integer getMemberID() {
        return memberID;
    }

    public void setMemberID(Integer memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberIDNumber() {
        return memberIDNumber;
    }

    public void setMemberIDNumber(String memberIDNumber) {
        this.memberIDNumber = memberIDNumber;
    }

    public Integer getMemberFamilyID() {
        return memberFamilyID;
    }

    public void setMemberFamilyID(Integer memberFamilyID) {
        this.memberFamilyID = memberFamilyID;
    }

    public Integer getSublineID() {
        return sublineID;
    }

    public void setSublineID(Integer sublineID) {
        this.sublineID = sublineID;
    }

    public Integer getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(Integer memberSex) {
        this.memberSex = memberSex;
    }

    public String getMemberNation() {
        return memberNation;
    }

    public void setMemberNation(String memberNation) {
        this.memberNation = memberNation;
    }

    public String getMemberPass() {
        return memberPass;
    }

    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }
}
