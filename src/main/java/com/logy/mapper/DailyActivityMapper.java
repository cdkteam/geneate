package com.logy.mapper;

import com.logy.form.DailyActivityForm;
import com.logy.form.UserForm;
import com.logy.mode.DailyActivity;
import com.logy.mode.User;

import java.util.List;


public interface DailyActivityMapper {
    List<DailyActivity> queryAllDailyActivity(DailyActivityForm dailyActivityForm);
    Integer insertDailyActivity(DailyActivity dailyActivity);
    Integer queryDailyByCreateDate(DailyActivityForm dailyActivityForm);
    Integer updateDailyActivity(DailyActivityForm dailyActivityForm);
}
