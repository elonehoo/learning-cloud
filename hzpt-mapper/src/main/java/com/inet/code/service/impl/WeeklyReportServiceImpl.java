package com.inet.code.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.entity.weeklyReport.po.WeeklyReport;
import com.inet.code.mapper.WeeklyReportMapper;
import com.inet.code.service.WeeklyReportService;
import org.springframework.stereotype.Service;

/**
 * 周报
 * @author HCY
 * @since 2021/5/8 2:59 下午
*/
@Service
public class WeeklyReportServiceImpl extends ServiceImpl<WeeklyReportMapper, WeeklyReport> implements WeeklyReportService {
}
