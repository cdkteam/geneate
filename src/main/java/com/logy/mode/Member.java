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
@Getter
@Setter
public class Member implements Serializable {
    private Integer memberID;
    private String memberName;
    private String memberBirthday;
    private String memberIDNumber;
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
}
