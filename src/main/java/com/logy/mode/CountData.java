package com.logy.mode;



import java.io.Serializable;

/**
 * 统计Bean类
 */

public class CountData implements Serializable {
    private Integer familys;
    private Integer sublines;
    private Integer members;
    private Integer admins;

    // 统计男女数量
    private Integer boys;
    private Integer girls;

    // 年龄分布
    private Integer nums;
    private Integer age;

    // 字辈分布
    private String mgName;

    // 家族支系统计
    private Integer sublineCount;
    private String familyName;

    // 民族分布
    private Integer nationCount;
    private String memberNation;

    public Integer getFamilys() {
        return familys;
    }

    public void setFamilys(Integer familys) {
        this.familys = familys;
    }

    public Integer getSublines() {
        return sublines;
    }

    public void setSublines(Integer sublines) {
        this.sublines = sublines;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Integer getAdmins() {
        return admins;
    }

    public void setAdmins(Integer admins) {
        this.admins = admins;
    }

    public Integer getBoys() {
        return boys;
    }

    public void setBoys(Integer boys) {
        this.boys = boys;
    }

    public Integer getGirls() {
        return girls;
    }

    public void setGirls(Integer girls) {
        this.girls = girls;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMgName() {
        return mgName;
    }

    public void setMgName(String mgName) {
        this.mgName = mgName;
    }

    public Integer getSublineCount() {
        return sublineCount;
    }

    public void setSublineCount(Integer sublineCount) {
        this.sublineCount = sublineCount;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getNationCount() {
        return nationCount;
    }

    public void setNationCount(Integer nationCount) {
        this.nationCount = nationCount;
    }

    public String getMemberNation() {
        return memberNation;
    }

    public void setMemberNation(String memberNation) {
        this.memberNation = memberNation;
    }
}
