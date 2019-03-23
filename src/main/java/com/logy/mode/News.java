package com.logy.mode;

import lombok.Data;

/**
 *
 *   
 * @author xky
 * @date 2019/3/21 22:13  
 * @param   
 * @return   
 */

@Data
public class News {
    private Long newsID;
    private String newsTitle;
    private String newsContent;
    private String newsTime;
    private Long newsFamilyID;
    private Integer newsType;
    private String createUser;
    private String familyName;
}
