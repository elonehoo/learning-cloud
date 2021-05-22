package com.inet.service;

public interface ReleaseTopicService {
    /**
     * 管理员发布题目
     * @Author MRJ
     * @Date 16:36 2021/5/17
     * @Param [originUrl（ 来源URL ）, issuerUserId（发布者id(UUID) ）, author（ 原作者 ）,
     * level（难度(0简单,1中等,2困难)）, labelId 标签id(UUID), headLine (标题 ), content(内容), status(状态 )]
     * @return java.lang.Boolean
     **/
    boolean release(String originUrl,String issuerUserId,String author
            ,boolean level,String labelId,String headLine,String content,String status);

    //设置题目表与标签表联系
    boolean topicLabel(String topicId,String labelId);

    //发布题解
    boolean releaseKey(String topicId,String answer,String throughputTime,int score);

    
    //题目与题解关系
    boolean topicKey(String topicId,String keyId);

}
