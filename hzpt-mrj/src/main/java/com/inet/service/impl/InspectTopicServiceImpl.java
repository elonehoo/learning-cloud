package com.inet.service.impl;

import com.inet.code.entity.gitLog.po.GitLog;
import com.inet.code.entity.userTopic.po.UserTopic;
import com.inet.code.service.GitLogService;
import com.inet.code.service.UserTopicService;
import com.inet.service.InspectTopicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author MRJ
 * @Date 20:25 2021/5/21
 * 管理员设置用户提交的题目答案的状态与分数
 **/
@Service
public class InspectTopicServiceImpl implements InspectTopicService {

    @Resource
    private GitLogService gitLogService;

    @Resource
    private UserTopicService userTopicService;

    private static final int PASS=1;


    /**
     * @Author MRJ
     * @Date 15:21 2021/5/18
     * @Param [id (gitId), status]
     * @return boolean
     * 设置提交记录的状态
     **/
    @Override
    public boolean setStatus(String id,String userId,String topicId,int status) {
        GitLog gitLog = new GitLog();
        gitLog.setId(id);
        gitLog.setStatus(status);
        gitLog.setGmtModify(new Date());
        updateUserTopic(status,userId,topicId);
        return gitLogService.updateById(gitLog);
    }

    /**
     * @Author MRJ
     * @Date 15:35 2021/5/18
     * @Param [ status(0未通过/1通过) 根据status选择添加或删除数据 ）, userId, topicId]
     * @return boolean
     * 管理员设置状态为通过后需要在用户题目关系表中更新
     **/
    @Override
    public boolean updateUserTopic(int status, String userId, String topicId) {
        if(PASS == status ){        //审核状态为1，表示通过
            UserTopic userTopic=new UserTopic();
            userTopic.setId(UUID.randomUUID().toString());
            userTopic.setUserId(userId);
            userTopic.setTopicId(topicId);
            userTopic.setGmtCreate(new Date());
            userTopic.setGmtModify(new Date());
            return userTopicService.save(userTopic);
        }else {     //未通过，删除数据
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_id",userId);
            map.put("topic_id",topicId);
            return userTopicService.removeByMap(map);
        }
    }
    
    /**
     * @Author MRJ
     * @Date 15:21 2021/5/18
     * @Param [id, score]
     * @return boolean
     * 设置分数
     **/
    @Override
    public boolean setScore(String id, int score) {
        GitLog gitLog = new GitLog();
        gitLog.setId(id);
        gitLog.setScore(score);
        gitLog.setGmtModify(new Date());
        return gitLogService.updateById(gitLog);
    }
}
