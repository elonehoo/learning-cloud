package com.inet.service;

import com.inet.code.entity.dailyReport.po.DailyReport;
import com.inet.code.entity.weeklyReport.po.WeeklyReport;

import java.util.List;

/**
 * @Author MRJ
 * @Date 11:55 2021/5/13
 * 查看日报
 **/
public interface ShowReportService {
    /**
     * @Author MRJ
     * @Date 12:22 2021/5/13
     * @Param [id]
     * @return com.inet.code.entity.dailyReport.po.DailyReport
     * 通过用户id查找提交的日报
     **/
    List<DailyReport> getDailyReport(String userId);

    /**
     * @Author MRJ
     * @Date 12:23 2021/5/13
     * @Param [id]
     * @return com.inet.code.entity.weeklyReport.po.WeeklyReport
     * 通过用户id查找提交的周报
     **/
    List<WeeklyReport> getWeeklyReport(String userId);


}
