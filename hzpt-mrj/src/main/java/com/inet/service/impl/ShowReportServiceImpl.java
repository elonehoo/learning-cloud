package com.inet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.dailyReport.po.DailyReport;
import com.inet.code.entity.weeklyReport.po.WeeklyReport;
import com.inet.code.service.DailyReportService;
import com.inet.code.service.WeeklyReportService;
import com.inet.service.ShowReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShowReportServiceImpl implements ShowReportService {

    @Resource
    WeeklyReportService weeklyReportService;

    @Resource
    DailyReportService dailyReportService;


    /**
     * @Author MRJ
     * @Date 12:22 2021/5/13
     * @Param [id]
     * @return com.inet.code.entity.dailyReport.po.DailyReport
     * 通过用户id查找提交的日报
     **/
    @Override
    public List<DailyReport> getDailyReport(String userId) {
        Map<String,Object> map=new HashMap();
        map.put("user_id",userId);
        return dailyReportService.getBaseMapper().selectByMap(map);
    }

    /**
     * @Author MRJ
     * @Date 12:23 2021/5/13
     * @Param [id]
     * @return com.inet.code.entity.weeklyReport.po.WeeklyReport
     * 通过用户id查找提交的周报
     **/
    @Override
    public List<WeeklyReport> getWeeklyReport(String userId) {
        Map<String,Object> map=new HashMap();
        map.put("user_id",userId);
        return weeklyReportService.getBaseMapper().selectByMap(map);
    }
}
