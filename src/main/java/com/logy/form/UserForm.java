package com.logy.form;


public class UserForm {
    private Integer adminID;
    private String adminName;
    private String adminAccount;
    private String adminPass;
    private String repassword;
    private String adminCreateDate;
    private Integer adminFamilyID;

    private Integer page;
    private Integer limit;

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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getAdminCreateDate() {
        return adminCreateDate;
    }

    public void setAdminCreateDate(String adminCreateDate) {
        this.adminCreateDate = adminCreateDate;
    }

    public Integer getAdminFamilyID() {
        return adminFamilyID;
    }

    public void setAdminFamilyID(Integer adminFamilyID) {
        this.adminFamilyID = adminFamilyID;
    }

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
