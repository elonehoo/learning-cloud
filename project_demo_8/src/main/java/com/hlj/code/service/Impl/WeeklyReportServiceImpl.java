package com.hlj.code.service.Impl;

import com.hlj.code.entity.vo.WeeklyReportVO;
import com.hlj.code.mapper.WeeklyReportMapper;
import com.hlj.code.service.WeeklyReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
 * @Description: 周报服务层
 * @author: hlj
 * @date: 2021-05-10
 */
@Service
public class WeeklyReportServiceImpl implements WeeklyReportService {

    @Resource
    WeeklyReportMapper weeklyReportMapper;

    /**
     * 返回所有周报
     * @return boolean 成功返回true，否则返回false
     */
    @Override
    public List<WeeklyReportVO> listWeeklyReport() {

        return weeklyReportMapper.selectAllWeeklyReport();
    }
}
