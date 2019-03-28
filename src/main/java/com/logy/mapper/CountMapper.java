package com.logy.mapper;

import com.logy.mode.CountData;

/**
 *    统计
 *   
 * @author xky
 * @date 2019/3/13 21:23  
 * @param   
 * @return   
 */
public interface CountMapper {
    /**
     * 家族数量、支系数量、总人数、管理员人数
     * @return
     */
    CountData countData();

    /**
     * 获取男女比例数量
     * @return
     */
    CountData countSex();
}
