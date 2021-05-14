package com.inet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.entity.weeklyReport.po.WeeklyReport;
import com.inet.code.mapper.WeeklyReportMapper;
import com.inet.service.WeeklyReportServer;
import com.inet.util.JwtUtil;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/11 14:18
 */
@Service
public class WeeklyServerImpl extends ServiceImpl<WeeklyReportMapper, WeeklyReport> implements WeeklyReportServer {

    /**
     * 保存周报
     *
     * @param token JwtToken
     * @param content 周报内容
     * @return 是否成功
     */
    @Override
    public boolean insertWeeklyReport(String token, String content) {
        Map<String, Object> claims = JwtUtil.getClaims(token);
        WeeklyReport weeklyReport = new WeeklyReport();
        weeklyReport.setId(UUID.randomUUID().toString());
        weeklyReport.setUserId((String) claims.get("userId"));
        weeklyReport.setAuditStatus(false);
        weeklyReport.setContent(content);
        weeklyReport.setGmtCreate(new Date());
        weeklyReport.setGmtModify(new Date());

        return this.save(weeklyReport);
    }
}
