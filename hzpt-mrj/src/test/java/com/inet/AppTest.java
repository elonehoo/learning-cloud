package com.inet;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.inet.code.entity.dailyReport.po.DailyReport;
import com.inet.code.entity.gitLog.po.GitLog;
import com.inet.code.mapper.DailyReportMapper;
import com.inet.code.service.DailyReportService;
import com.inet.code.service.GitLogService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {

    @Resource
    DailyReportService dailyReportService;

    @Resource
    DailyReportMapper dailyReportMapper;

    @Resource
    GitLogService gitLogService;


    @Test
    public void shouldAnswerWithTrue() {
        GitLog gitLog = new GitLog();
        gitLog.setId("123456");
        gitLog.setStatus(0);
        gitLog.setGmtModify(new Date());
    }



}
