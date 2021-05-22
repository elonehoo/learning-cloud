package com.inet.service;



/**
 * @Author MRJ
 * @Date 13:25 2021/5/18
 * 管理员对用户提交的答案进行打分,对用户提交的状态进行设置
 **/
public interface InspectTopicService {

    /**
     * @Author MRJ
     * @Date 15:21 2021/5/18
     * @Param [id, status]
     * @return boolean
     * 设置提交记录的状态
     **/
    boolean setStatus(String id,String userId,String topicId,int status);

    /**
     * @Author MRJ
     * @Date 15:35 2021/5/18
     * @Param [ status(0未通过/1通过) 根据status选择添加或删除数据 ）, userId, TopicId]
     * @return boolean
     * 管理员设置状态为通过后需要在用户题目关系表中更新
     **/
    boolean updateUserTopic(int status, String userId,  String topicId);

    /**
     * @Author MRJ
     * @Date 15:21 2021/5/18
     * @Param [id(gitId), score]
     * @return boolean
     * 设置分数
     **/
    boolean setScore(String id,int score);
}
