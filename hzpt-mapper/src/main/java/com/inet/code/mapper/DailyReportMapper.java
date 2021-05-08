package com.inet.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.code.entity.dailyReport.po.DailyReport;
import org.apache.ibatis.annotations.Mapper;

/**
 * 日报
 * @author HCY
 * @since 2021/5/8 3:07 下午
*/
@Mapper
public interface DailyReportMapper extends BaseMapper<DailyReport> {
}
