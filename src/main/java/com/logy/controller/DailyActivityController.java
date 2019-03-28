package com.logy.controller;


import com.logy.form.DailyActivityForm;
import com.logy.form.UserForm;
import com.logy.mode.DailyActivity;
import com.logy.mode.User;
import com.logy.service.inter.DailyActivityService;
import com.logy.service.inter.UserService;
import com.logy.utils.DataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *    获取日活跃量数据。用户每次访问首页数量
 *
 * @author xky
 * @date 2019/3/14 0:00
 * @param
 * @return
 */
@RestController
@RequestMapping("daily")
public class DailyActivityController {
    @Autowired
    private DailyActivityService dailyActivityService;

    @RequestMapping("d_list")
    public DataResponse queryAllDailyActivity(DailyActivityForm dailyActivityForm) {
        return dailyActivityService.queryAllDailyActivity(dailyActivityForm);
    }

    @RequestMapping("d_i")
    public DataResponse insertDailyActivity() {
        return dailyActivityService.insertDailyActivity();
    }

}
