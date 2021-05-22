package com.inet.service.impl;

import com.inet.code.entity.gitLog.po.GitLog;
import com.inet.code.service.GitLogService;
import com.inet.service.CommitGitLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class CommitGitLogServiceImpl implements CommitGitLogService {

    @Resource
    private GitLogService gitLogService;

    /**
     * 用户提交题目记录
     * @Author MRJ
     * @Date 12:51 2021/5/18
     * @Param [userId(用户id), topicId(题目id), answer(提交的答案), status(提交状态:0未通过/1通过) , startTime（解题开始时间）, endTime（解题结束时间）]
     * @return boolean
     **/
    @Override
    public boolean commit(String userId, String topicId, String answer, int status, Date startTime, Date endTime) {
        GitLog gitLog=new GitLog();
        UUID uuid = UUID.randomUUID();
        gitLog.setId(uuid.toString());
        gitLog.setUserId(userId);
        gitLog.setAnswer(answer);
        //状态
        gitLog.setStatus(status);
        gitLog.setStartTime(startTime);
        gitLog.setEndTime(endTime);
        gitLog.setGmtCreate(new Date());
        gitLog.setGmtModify(new Date());
        return gitLogService.save(gitLog);
    }




}
