package com.inet.code.controller;

import com.inet.code.entity.po.Result;
import com.inet.code.entity.vo.WeeklyReportVO;
import com.inet.code.service.WeeklyReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 周报控制层
 * @author: hlj
 * @date: 2021-05-10
*/
@Api("周报控制层")
@CrossOrigin
@RestController
public class WeeklyReportController {

    @Resource
    WeeklyReportService weeklyReportService;

    @ApiOperation("展示周报")
    @PostMapping("/showWeeklyReport")
    public Result showDailyReport(){
        List<WeeklyReportVO> listWeeklyReport = weeklyReportService.listWeeklyReport();
        return new Result().result200(listWeeklyReport,"/reportUpLoad");
    }
}
