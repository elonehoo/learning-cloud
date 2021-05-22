package com.inet.service;

import java.util.Date;

/**
 * @Author MRJ
 * @Date 13:25 2021/5/18
 * 用户提交题目
 **/
public interface CommitGitLogService {
    /**
     * 用户提交题目记录
     * @Author MRJ
     * @Date 12:51 2021/5/18
     * @Param [userId(用户id), topicId(题目id), answer(提交的答案), status(提交状态:0未通过/1通过) , startTime（解题开始时间）, endTime（解题结束时间）]
     * @return boolean
     **/
    boolean commit(String userId, String topicId, String answer, int status,Date startTime,Date endTime);



}
