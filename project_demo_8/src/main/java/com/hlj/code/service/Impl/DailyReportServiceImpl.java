package com.hlj.code.service.Impl;

import com.hlj.code.entity.dto.DailyReportDTO;
import com.hlj.code.entity.po.DailyReport;
import com.hlj.code.entity.vo.DailyReportVO;
import com.hlj.code.mapper.DailyReportMapper;
import com.hlj.code.service.DailyReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Description: 日报服务层
 * @author: hlj
 * @date: 2021-05-10
 */
@Service
public class DailyReportServiceImpl implements DailyReportService {

    @Resource
    DailyReportMapper dailyReportMapper;


    /**
     * 处理日报数据并插入数据库，返回插入结果
     * @param dailyReportDTO 自定义传输类
     * @return boolean 成功返回true，否则返回false
     */
    @Override
    public boolean saveDailyReport(DailyReportDTO dailyReportDTO) {
        DailyReport dailyReport = new DailyReport(UUID.randomUUID().toString(),dailyReportDTO.getUserId(),0,dailyReportDTO.getContent());
        int row = dailyReportMapper.insertDailyReport(dailyReport);
        return row >= 1;
    }

    /**
     * 返回所有日报
     * @return boolean 成功返回true，否则返回false
     */
    @Override
    public List<DailyReportVO> listDailyReport() {

        return dailyReportMapper.selectAllDailyReport();
    }
}
