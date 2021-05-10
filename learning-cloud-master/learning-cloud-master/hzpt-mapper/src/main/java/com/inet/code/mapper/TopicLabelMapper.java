package com.inet.code.mapper;

import com.inet.code.entity.topicLabel.po.TopicLabel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 题目标签关系表
 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Mapper
public interface TopicLabelMapper extends BaseMapper<TopicLabel> {

}
