package com.logy.form;

import lombok.Data;

@Data
public class CountForm {
    private Integer memberFamilyID;
    private Integer sublineID;

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
}
