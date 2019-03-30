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
}
