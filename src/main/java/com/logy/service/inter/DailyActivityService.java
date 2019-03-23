package com.logy.service.inter;

import com.logy.form.DailyActivityForm;
import com.logy.mode.DailyActivity;
import com.logy.utils.DataResponse;


public interface DailyActivityService {
    DataResponse queryAllDailyActivity(DailyActivityForm dailyActivityForm);
    DataResponse insertDailyActivity();
    DataResponse updateDailyActivity(DailyActivityForm dailyActivityForm);
}
