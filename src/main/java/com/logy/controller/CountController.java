package com.logy.controller;

import com.logy.form.CountForm;
import com.logy.service.inter.CountService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * 基础数据统计
 */
@RestController
@RequestMapping("count")
public class CountController {
    /**
     * 统计数据对象
     */
    @Autowired
    private CountService countService;

    /**
     * 获取后台首页 家族数量、支系数量、总人数、管理员数量
     * 统计：年龄分布、男女比例
     * @return
     */
    @RequestMapping("c_index_data")
    public DataResponse countData(CountForm countForm, Integer type) {
        return countService.countBaseData(countForm, type);
    }

}
