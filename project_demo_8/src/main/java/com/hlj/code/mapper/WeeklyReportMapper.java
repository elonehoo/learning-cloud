package com.hlj.code.mapper;

import com.hlj.code.entity.vo.WeeklyReportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 日报数据库操作
 * @author: hlj
 * @date: 2021-05-10
 */
@Mapper
public interface WeeklyReportMapper {
    /**
     * 查找所有日报
     * @return List<WeeklyReportVO> 所有周报集合
     */
    List<WeeklyReportVO> selectAllWeeklyReport();

}
