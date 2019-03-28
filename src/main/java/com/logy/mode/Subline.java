package com.logy.mode;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *    支系实体类
 *
 * @author xky
 * @date 2019/3/10 14:14
 * @param
 * @return
 */
@Getter
@Setter
public class Subline implements Serializable {
    private Integer subID;
    private Integer subFamilyID;
    private String subName;
    private String subGelogy;
    private String subFamily;
    private String subCreateDate;
    private String subCode;
    private String subAddress;
}
