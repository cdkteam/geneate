package com.logy.mode;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *    网站用户实体类（家族成员）
 *
 * @author xky
 * @date 2019/3/11 4:37
 * @param
 * @return
 */

public class Member implements Serializable {
    private Integer memberID;
    private String memberName;
    private String memberBirthday;
    private String memberIDNumber;
    private String fatherIDNumber;
    private String memberFamilyID;
    private Integer isFather;
    private Integer fatherID;
    private Integer sublineID;
    private String memberPhone;
    private String memberPass;
    private String memberHead;
    private String memberAddress;
    private String memberNation;
    private String memberSex;
    private String memberGenealogy;
    private String memberRelation;
    private String memberCode;
    private String memberCreateDate;
    private Integer memberCreateUser;
    private String sublineGenealogy;

    private String fatherName;

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

    public String getMemberBirthday() {
        return memberBirthday;
    }

    public void setMemberBirthday(String memberBirthday) {
        this.memberBirthday = memberBirthday;
    }

    public String getMemberIDNumber() {
        return memberIDNumber;
    }

    public void setMemberIDNumber(String memberIDNumber) {
        this.memberIDNumber = memberIDNumber;
    }

    public String getFatherIDNumber() {
        return fatherIDNumber;
    }

    public void setFatherIDNumber(String fatherIDNumber) {
        this.fatherIDNumber = fatherIDNumber;
    }

    public String getMemberFamilyID() {
        return memberFamilyID;
    }

    public void setMemberFamilyID(String memberFamilyID) {
        this.memberFamilyID = memberFamilyID;
    }

    public Integer getIsFather() {
        return isFather;
    }

    public void setIsFather(Integer isFather) {
        this.isFather = isFather;
    }

    public Integer getFatherID() {
        return fatherID;
    }

    public void setFatherID(Integer fatherID) {
        this.fatherID = fatherID;
    }

    public Integer getSublineID() {
        return sublineID;
    }

    public void setSublineID(Integer sublineID) {
        this.sublineID = sublineID;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberPass() {
        return memberPass;
    }

    public void setMemberPass(String memberPass) {
        this.memberPass = memberPass;
    }

    public String getMemberHead() {
        return memberHead;
    }

    public void setMemberHead(String memberHead) {
        this.memberHead = memberHead;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberNation() {
        return memberNation;
    }

    public void setMemberNation(String memberNation) {
        this.memberNation = memberNation;
    }

    public String getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(String memberSex) {
        this.memberSex = memberSex;
    }

    public String getMemberGenealogy() {
        return memberGenealogy;
    }

    public void setMemberGenealogy(String memberGenealogy) {
        this.memberGenealogy = memberGenealogy;
    }

    public String getMemberRelation() {
        return memberRelation;
    }

    public void setMemberRelation(String memberRelation) {
        this.memberRelation = memberRelation;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberCreateDate() {
        return memberCreateDate;
    }

    public void setMemberCreateDate(String memberCreateDate) {
        this.memberCreateDate = memberCreateDate;
    }

    public Integer getMemberCreateUser() {
        return memberCreateUser;
    }

    public void setMemberCreateUser(Integer memberCreateUser) {
        this.memberCreateUser = memberCreateUser;
    }

    public String getSublineGenealogy() {
        return sublineGenealogy;
    }

    public void setSublineGenealogy(String sublineGenealogy) {
        this.sublineGenealogy = sublineGenealogy;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
