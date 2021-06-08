package com.inet.code.service;

import com.inet.code.entity.po.TopicLabel;

/**
 * 题目标签关系服务层
 * @author: hlj
 * @date: 2021-06-06
*/
public interface TopicLabelService {
    /**
     * 新增题目标签关系
     * @param topicLabel 对应数据库文章类型关系表字段
     * @return boolean 返回数据库操作是否成功
     */
    boolean saveTopicLabelFromWebsite(TopicLabel topicLabel);
}
