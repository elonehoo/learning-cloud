package com.inet.code.service.Impl;

import com.inet.code.entity.po.TopicLabel;
import com.inet.code.mapper.TopicLabelMapper;
import com.inet.code.service.TopicLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 题目标签关系服务层
 * @author: hlj
 * @date: 2021-06-06
*/
@Service
public class TopicLabelServiceImpl implements TopicLabelService {

    @Resource
    private TopicLabelMapper topicLabelMapper;
    /**
     * 新增题目标签关系
     * @param topicLabel 对应数据库文章类型关系表字段
     * @return boolean 返回数据库操作是否成功
     */
    @Override
    public boolean saveTopicLabelFromWebsite(TopicLabel topicLabel) {
        int row = topicLabelMapper.insertTopicLabelFromWebsite(topicLabel);
        return row>=1;
    }
}
