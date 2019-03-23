package com.logy.form;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
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

}
