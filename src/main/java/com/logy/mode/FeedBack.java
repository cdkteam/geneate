package com.logy.mode;

import lombok.Data;

/**
 *    反馈实体类
 *
 * @author xky
 * @date 2019/3/21 11:20
 * @param
 * @return
 */
@Data
public class FeedBack {
    private Long fbID;
    private Long fbmemberID;
    private String fbQuestion;
    private String fbAnswer;
}
