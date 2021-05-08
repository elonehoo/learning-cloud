package com.inet.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.entity.dailyReport.po.DailyReport;
import com.inet.code.mapper.DailyReportMapper;
import com.inet.code.service.DailyReportService;
import org.springframework.stereotype.Service;

/**
 * 日报
 * @author HCY
 * @since 2021/5/8 3:12 下午
*/
@Service
public class DailyReportServiceImpl extends ServiceImpl<DailyReportMapper, DailyReport> implements DailyReportService {
}
