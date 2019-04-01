package com.logy.mode;

import lombok.Data;

import java.io.Serializable;

/**
 * 统计Bean类
 */
@Data
public class CountData implements Serializable {
    private Integer familys;
    private Integer sublines;
    private Integer members;
    private Integer admins;

    // 统计男女数量
    private Integer boys;
    private Integer girls;

    // 年龄分布
    private Integer nums;
    private Integer age;

    // 辈分分布
    private String mgName;

}
