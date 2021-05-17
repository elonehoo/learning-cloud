package com.inet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.entity.weeklyReport.po.WeeklyReport;

/**
 * 周报
 * @author HCY
 * @since 2021/5/8 2:57 下午
*/
public interface WeeklyReportServer {
    /**
     * 上传周报
     *
     * @param token JwtToken
     * @param content 周报内容
     * @return 是否成功
     */
    boolean insertWeeklyReport(String token, String content);
}
