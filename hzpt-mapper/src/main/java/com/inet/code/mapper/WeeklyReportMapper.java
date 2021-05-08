package com.inet.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.code.entity.weeklyReport.po.WeeklyReport;
import org.apache.ibatis.annotations.Mapper;

/**
 * 周报
 * @author HCY
 * @since 2021/5/8 2:59 下午
*/
@Mapper
public interface WeeklyReportMapper extends BaseMapper<WeeklyReport> {
}
