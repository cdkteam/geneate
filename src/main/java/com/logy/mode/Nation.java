package com.logy.mode;

import lombok.Data;

/**
 *    民族类
 *
 * @author xky
 * @date 2019/3/18 14:04
 * @param
 * @return
 */

public class Nation {
    private Integer nationID;
    private String nationName;

    public Integer getNationID() {
        return nationID;
    }

    public void setNationID(Integer nationID) {
        this.nationID = nationID;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
}
