package com.inet.code.mapper;

import com.inet.code.entity.po.Topic;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目数据库操作
 * @author: hlj
 * @date: 2021-06-06
*/
@Mapper
public interface TopicMapper {
    /**
     * 新增题目
     * @param topic 对应数据库题目表字段
     * @return int 返回插入成功行数
    */
    int insertTopicFromWebsite(Topic topic);
}
