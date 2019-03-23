package com.logy.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
/**
 *    日期转换工具类
 *
 * @author xky
 * @date 2019/3/21 18:51
 * @param
 * @return
 */
public class DateUtils {
    private static LocalDate localDate;
    private static LocalDate firstDay;
    private static LocalDate lastDay;
    private static ZoneId zone;
    private static Instant finstant;
    private static Instant lastinstant;
    private static Date startDate;
    private static Date endDate;

    static {
        /**
         * localDate 当前日期
         * firstDay 当月首日
         * lastDay 当月最后一日
         */
        localDate = LocalDate.now();
        firstDay = LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);
        lastDay = localDate.with(TemporalAdjusters.lastDayOfMonth());

        /**
         * LocalDate 转 Date
         */
        zone = ZoneId.systemDefault();
        finstant = firstDay.atStartOfDay().atZone(zone).toInstant();
        lastinstant = lastDay.atStartOfDay().atZone(zone).toInstant();

        startDate = Date.from(finstant);
        endDate = Date.from(lastinstant);
    }

    public static final LocalDate getLocalDateNow() {
        return localDate;
    }


    public static final Date getStartDate() {
        return startDate;
    }

    public static final Date getEndDate() {
        return endDate;
    }
}
