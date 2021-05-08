package com.inet.code.mapper;

import com.inet.code.entity.topic.po.Topic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 题目表
 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {

}
