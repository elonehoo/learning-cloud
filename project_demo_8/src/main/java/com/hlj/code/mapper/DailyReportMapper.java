package com.hlj.code.mapper;

import com.hlj.code.entity.po.DailyReport;
import com.hlj.code.entity.vo.DailyReportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 日报数据库操作
 * @author: hlj
 * @date: 2021-05-10
*/
@Mapper
public interface DailyReportMapper {
    /**
     * 插入一条日报
     * @param dailyReport 与数据库日报表对应
     * @return int 插入成功行数
    */
    int insertDailyReport(DailyReport dailyReport);
    /**
     * 查找所有日报
     * @return List<DailyReportVO> 所有日报集合
     */
    List<DailyReportVO> selectAllDailyReport();
}
