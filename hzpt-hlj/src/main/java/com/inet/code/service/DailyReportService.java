package com.inet.code.service;

import com.inet.code.entity.dto.DailyReportDTO;
import com.inet.code.entity.vo.DailyReportVO;

import java.util.List;

/**
 * @Description: 日报服务层
 * @author: hlj
 * @date: 2021-05-10
*/
public interface DailyReportService {
    /**
     * 处理日报数据并插入数据库，返回插入结果
     * @param dailyReportDTO 自定义传输类
     * @return boolean 成功返回true，否则返回false
    */
    boolean saveDailyReport(DailyReportDTO dailyReportDTO);
    /**
     * 返回所有日报
     * @return boolean 成功返回true，否则返回false
     */
    List<DailyReportVO> listDailyReport();
}
