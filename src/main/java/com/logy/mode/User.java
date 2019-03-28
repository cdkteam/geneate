package com.logy.mode;

import java.io.Serializable;

/**
 *    用户信息类
 *
 * @author xky
 * @date 2019/3/7 22:11
 * @param
 * @return
 */
public class User implements Serializable {
    private Integer adminID;
    private String adminName;
    private String adminAccount;
    private String adminPass;
    private Integer adminFamilyID;
    private String adminCreateDate;

    public Integer getAdminID() {
        return adminID;
    }

    public void setAdminID(Integer adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public Integer getAdminFamilyID() {
        return adminFamilyID;
    }

    public void setAdminFamilyID(Integer adminFamilyID) {
        this.adminFamilyID = adminFamilyID;
    }

    public String getAdminCreateDate() {
        return adminCreateDate;
    }

    public void setAdminCreateDate(String adminCreateDate) {
        this.adminCreateDate = adminCreateDate;
    }
}
