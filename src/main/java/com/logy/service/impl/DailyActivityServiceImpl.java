package com.logy.service.impl;

import com.logy.form.DailyActivityForm;
import com.logy.mapper.DailyActivityMapper;
import com.logy.mode.DailyActivity;
import com.logy.service.inter.DailyActivityService;
import com.logy.utils.DataResponse;
import com.logy.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;

@Service
public class DailyActivityServiceImpl implements DailyActivityService {
    @Autowired
    private DailyActivityMapper dailyActivityMapper;

    @Override
    public DataResponse queryAllDailyActivity(DailyActivityForm dailyActivityForm) {
        DataResponse<List<DailyActivity>> dataResponse = new DataResponse<>();

        dailyActivityForm.setStartTime(DateUtils.getStartDate());
        dailyActivityForm.setEndTime(DateUtils.getEndDate());
        List<DailyActivity> dailyActivities = dailyActivityMapper.queryAllDailyActivity(dailyActivityForm);
        if(!dailyActivities.isEmpty()) {
            dataResponse.setData(dailyActivities);
        } else {
            dataResponse.setMessage("no data");
        }
        return dataResponse;
    }

    @Override
    public DataResponse insertDailyActivity() {
        DataResponse dataResponse = new DataResponse<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd");
        String day = DateUtils.getLocalDateNow().format(df);
        DailyActivityForm dailyActivityForm = new DailyActivityForm();
        dailyActivityForm.setTime(Integer.valueOf(day));
        dailyActivityForm.setStartTime(DateUtils.getStartDate());
        dailyActivityForm.setEndTime(DateUtils.getEndDate());
        int n = dailyActivityMapper.queryDailyByCreateDate(dailyActivityForm);
        int result = 0;
        if(n > 0) {
            dailyActivityMapper.updateDailyActivity(dailyActivityForm);
        } else {
            DailyActivity dailyActivity  = new DailyActivity();
            dailyActivity.setTime(Integer.valueOf(day));
            dailyActivity.setNumber(1);
            result = dailyActivityMapper.insertDailyActivity(dailyActivity);
        }

        if(result == 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        return dataResponse;
    }

    @Override
    public DataResponse updateDailyActivity(DailyActivityForm dailyActivityForm) {
        DataResponse dataResponse = new DataResponse<>();
        int result = dailyActivityMapper.updateDailyActivity(dailyActivityForm);
        if(result == 0) {
            dataResponse.setMessage("fail");
            dataResponse.setCode(500);
        }
        return dataResponse;
    }
}
