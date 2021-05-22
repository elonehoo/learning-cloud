package com.inet.service.impl;

import com.inet.code.entity.key.po.Key;
import com.inet.code.entity.topic.po.Topic;
import com.inet.code.entity.topicKey.po.TopicKey;
import com.inet.code.entity.topicLabel.po.TopicLabel;
import com.inet.code.service.KeyService;
import com.inet.code.service.TopicKeyService;
import com.inet.code.service.TopicLabelService;
import com.inet.code.service.TopicService;
import com.inet.service.ReleaseTopicService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

public class ReleaseTopicServiceImpl implements ReleaseTopicService {

    @Resource
    TopicService topicService;

    @Resource
    TopicLabelService topicLabelService;

    @Resource
    KeyService keyService;

    @Resource
    TopicKeyService topicKeyService;

    /**
     * 管理员发布题目
     * @Author MRJ
     * @Date 16:36 2021/5/17
     * @Param [originUrl（ 来源URL ）, issuerUserId（发布者id(UUID) ）, author（ 原作者 ）,
     * level（难度(0简单,1中等,2困难)）, labelId 标签id(UUID), headLine (标题 ), content(内容), status(状态 )]
     * @return java.lang.Boolean
     **/
    @Override
    public boolean release(String originUrl, String issuerUserId, String author, boolean level
            , String labelId, String headLine, String content, String status) {
        Topic topic = new Topic();
        String id = UUID.randomUUID().toString();
        topic.setId(id);
        topic.setOriginUrl(originUrl);
        topic.setIssuerUserId(issuerUserId);
        topic.setAuthor(author);
        topic.setLevel(level);
        topic.setLabelId(labelId);
        topic.setHeadline(headLine);
        //TODO
//        topic.setContent(content);
//        topic.setStatus(status)
        topic.setGmtCreate(new Date());
        topic.setGmtModify(new Date());

        topicLabel(id,labelId);
        return topicService.save(topic);
    }

    /**
     * @Author MRJ
     * @Date 10:57 2021/5/22
     * @Param [topicId, labelId]
     * @return boolean
     * 题目与标签关联
     **/
    @Override
    public boolean topicLabel(String topicId, String labelId) {
        TopicLabel topicLabel=new TopicLabel();
        topicLabel.setId(UUID.randomUUID().toString());
        topicLabel.setTopicId(topicId);
        topicLabel.setLabelId(labelId);
        topicLabel.setGmtCreate(new Date());
        topicLabel.setGmtModify(new Date());

        return topicLabelService.save(topicLabel);
    }

    /**
     * @Author MRJ
     * @Date 11:23 2021/5/22
     * @Param [answer, throughputTime, score]
     * @return boolean
     * 管理员发布题解
     **/
    @Override
    public boolean releaseKey(String topicId,String answer, String throughputTime, int score) {
        Key key=new Key();
        String id = UUID.randomUUID().toString();
        key.setId(id);
        key.setAnswer(answer);
        key.setThroughputTime(throughputTime);
        key.setScore(score);
        key.setGmtCreate(new Date());
        key.setGmtModify(new Date());

        topicKey(topicId,id);
        return keyService.save(key);
    }

    /**
     * @Author MRJ
     * @Date 11:07 2021/5/22
     * @Param [topicId, keyId]
     * @return boolean
     * //题目与题解关系
     **/
    @Override
    public boolean topicKey(String topicId, String keyId) {
        TopicKey topicKey=new TopicKey();
        topicKey.setId(UUID.randomUUID().toString());
        topicKey.setTopicId(topicId);
        topicKey.setKeyId(keyId);
        topicKey.setGmtCreate(new Date());
        topicKey.setGmtModify(new Date());

        return topicKeyService.save(topicKey);
    }
}
