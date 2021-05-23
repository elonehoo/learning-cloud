package com.inet.code.controller;

import com.inet.code.entity.dto.DailyReportDTO;
import com.inet.code.entity.po.Result;
import com.inet.code.entity.vo.DailyReportVO;
import com.inet.code.service.DailyReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 日报控制层
 * @author: hlj
 * @date: 2021-05-10
*/
@Api("日报控制层")
@CrossOrigin
@RestController
public class DailyReportController {

    @Resource
    DailyReportService dailyReportService;

    @ApiOperation("上传日报")
    @PostMapping("/reportUpLoad")
    public boolean reportUpLoad(@RequestBody DailyReportDTO dailyReportDTO){
        boolean b = dailyReportService.saveDailyReport(dailyReportDTO);
        return b;
    }

    @ApiOperation("展示日报")
    @PostMapping("/showDailyReport")
    public Result showDailyReport(){
        List<DailyReportVO> listDailyReport = dailyReportService.listDailyReport();
        return new Result().result200(listDailyReport,"/reportUpLoad");
    }
}
