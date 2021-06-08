package com.inet.code.mapper;

import com.inet.code.entity.po.TopicLabel;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目标签关系数据库操作
 * @author: hlj
 * @date: 2021-06-06
*/
@Mapper
public interface TopicLabelMapper {
    /**
     * 新增题目标签关系
     * @param topicLabel 对应数据库题目标签关系表字段
     * @return int 返回插入成功行数
    */
    int insertTopicLabelFromWebsite(TopicLabel topicLabel);
}
