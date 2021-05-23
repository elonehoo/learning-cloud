package com.inet.code.service;

import com.inet.code.entity.vo.WeeklyReportVO;

import java.util.List;

/**
 * @Description: 周报服务层
 * @author: hlj
 * @date: 2021-05-10
*/
public interface WeeklyReportService {
    /**
     * 返回所有周报
     * @return boolean 成功返回true，否则返回false
     */
    List<WeeklyReportVO> listWeeklyReport();

}
