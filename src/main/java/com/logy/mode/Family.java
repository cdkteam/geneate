package com.logy.mode;

import java.io.Serializable;

/**
 *    家族实体类
 *
 * @author XingZengZhi
 * @date 2019/3/10 17:32
 * @param
 * @return
 */
public class Family implements Serializable {
    private Integer familyID;
    private String familyName;
    private Integer familyNum;
    private String familyCreateDate;

    public Integer getFamilyID() {
        return familyID;
    }

    public void setFamilyID(Integer familyID) {
        this.familyID = familyID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Integer getFamilyNum() {
        return familyNum;
    }

    public void setFamilyNum(Integer familyNum) {
        this.familyNum = familyNum;
    }

    public String getFamilyCreateDate() {
        return familyCreateDate;
    }

    public void setFamilyCreateDate(String familyCreateDate) {
        this.familyCreateDate = familyCreateDate;
    }
}
