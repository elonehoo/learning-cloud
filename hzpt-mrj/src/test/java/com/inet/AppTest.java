package com.inet;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.dailyReport.po.DailyReport;
import com.inet.code.mapper.DailyReportMapper;
import com.inet.code.service.DailyReportService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
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


    @Test
    public void shouldAnswerWithTrue() {
        Map map=new HashMap();
        map.put("user_id","222");
        System.out.println(dailyReportService.getBaseMapper().selectByMap(map));
//        List list = dailyReportMapper.selectByMap(map);
//        System.out.println(list);
//        System.out.println("==================================");
//        System.out.println(dailyReportMapper.selectById("123456"));
//        System.out.println("==================================");
//        DailyReport dailyReport = new DailyReport();
//        dailyReport.setUserId("222");
//        dailyReport.setAuditStatus(true);
//        System.out.println(dailyReportService.list(new QueryWrapper<>(dailyReport)));

    }



}
