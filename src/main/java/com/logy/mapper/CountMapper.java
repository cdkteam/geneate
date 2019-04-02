package com.logy.mapper;

import com.logy.form.CountForm;
import com.logy.mode.CountData;

import java.util.List;

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
    List<CountData> countData();

    /**
     * 获取男女比例数量
     * @return
     */
    List<CountData> countSex(CountForm countForm);

    /**
     * 获取年龄分布
     * @return
     */
    List<CountData> countAge(CountForm countForm);

    /**
     * 获取字辈分布
     * @return
     */
    List<CountData> countSubline(CountForm countForm);
}
