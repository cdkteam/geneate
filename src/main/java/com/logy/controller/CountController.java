package com.logy.controller;

import com.logy.service.inter.CountService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 活跃用户数量控制类
 */
@RestController
@RequestMapping("count")
public class CountController {
    /**
     * 活跃用户数量控制类对象
     */
    @Autowired
    private CountService countService;

    /**
     * 获取后台首页 家族数量、支系数量、总人数、管理员数量
     * @return
     */
    @RequestMapping("c_index_data")
    public DataResponse countData() {
        return countService.countBaseData();
    }

    /**
     * 获取男女比例
     * @return
     */
    @RequestMapping("c_index_sex")
    public DataResponse countSex() {
        return countService.countSex();
    }
}
