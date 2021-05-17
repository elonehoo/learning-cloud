package com.inet.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.inet.code.entity.assignment.po.Assignment;
import com.inet.code.entity.assignmentGit.po.AssignmentGit;
import com.inet.code.entity.dailyReport.po.DailyReport;
import com.inet.code.entity.discussArticle.po.DiscussArticle;
import com.inet.code.entity.gitLog.po.GitLog;
import com.inet.code.entity.like.po.Like;
import com.inet.code.entity.plan.po.Plan;
import com.inet.code.entity.user.po.User;
import com.inet.code.entity.userTopic.po.UserTopic;
import com.inet.code.entity.weeklyReport.po.WeeklyReport;
import com.inet.code.mapper.*;
import com.inet.entity.VO.MonitorMessage;
import com.inet.service.MonitorServer;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/17 12:57
 */
@Service
public class MonitorServerImpl implements MonitorServer {

    private final UserMapper userMapper;
    private final LikeMapper likeMapper;
    private final DiscussArticleMapper discussArticleMapper;
    private final AssignmentMapper assignmentMapper;
    private final AssignmentGitMapper assignmentGitMapper;
    private final GitLogMapper gitLogMapper;
    private final UserTopicMapper userTopicMapper;
    private final PlanMapper planMapper;
    private final DailyReportMapper dailyReportMapper;
    private final WeeklyReportMapper weeklyReportMapper;

    /**
     * 自动注入
     */
    public MonitorServerImpl(UserMapper userMapper, LikeMapper likeMapper, DiscussArticleMapper discussArticleMapper,
                          AssignmentMapper assignmentMapper, AssignmentGitMapper assignmentGitMapper,
                          GitLogMapper gitLogMapper, UserTopicMapper userTopicMapper, PlanMapper planMapper,
                          DailyReportMapper dailyReportMapper, WeeklyReportMapper weeklyReportMapper) {

        this.userMapper = userMapper;
        this.likeMapper = likeMapper;
        this.discussArticleMapper=discussArticleMapper;
        this.assignmentMapper = assignmentMapper;
        this.assignmentGitMapper = assignmentGitMapper;
        this.gitLogMapper = gitLogMapper;
        this.userTopicMapper = userTopicMapper;
        this.planMapper = planMapper;
        this.dailyReportMapper = dailyReportMapper;
        this.weeklyReportMapper = weeklyReportMapper;
    }

    /**
     * 查询所有用户信息
     * @return 用户信息
     */
    @Override
    public List<User> selectAllUser() {
        return userMapper.selectList(new QueryWrapper<>());
    }

    /**
     * 通过id查询需要监控的信息
     */
    @Override
    public MonitorMessage selectMessageById(Serializable id) {

        // 获取用户点赞数
        QueryWrapper<Like> likeQueryWrapper = new QueryWrapper<>();
        likeQueryWrapper.eq("user_id", id);
        int like = likeMapper.selectCount(likeQueryWrapper);

        // 获取用户评论的文章数
        QueryWrapper<DiscussArticle> discussArticleQueryWrapper = new QueryWrapper<>();
        discussArticleQueryWrapper.eq("user_id", id);
        int discussArticle = discussArticleMapper.selectCount(discussArticleQueryWrapper);

        // 获取应完成的任务数
        QueryWrapper<Assignment> assignmentQueryWrapper = new QueryWrapper<>();
        assignmentQueryWrapper.eq("user_id", id);
        int assignment = assignmentMapper.selectCount(assignmentQueryWrapper);

        // 获取实际完成的任务数
        QueryWrapper<AssignmentGit> assignmentGitQueryWrapper = new QueryWrapper<>();
        assignmentGitQueryWrapper.eq("user_id", id);
        int assignmentGit = assignmentGitMapper.selectCount(assignmentGitQueryWrapper);

        // 提交的算法题数
        QueryWrapper<GitLog> gitLogQueryWrapper = new QueryWrapper<>();
        gitLogQueryWrapper.eq("user_id", id);
        int gitLog = gitLogMapper.selectCount(gitLogQueryWrapper);

        // 获取审核通过的算法题数
        QueryWrapper<UserTopic> userTopicQueryWrapper = new QueryWrapper<>();
        userTopicQueryWrapper.eq("user_id", id);
        int userTopic = userTopicMapper.selectCount(userTopicQueryWrapper);

        // 获取用户计划
        QueryWrapper<Plan> planQueryWrapper = new QueryWrapper<>();
        planQueryWrapper.eq("user_id", id);
        int plan = planMapper.selectCount(planQueryWrapper);

        // 获取日报数
        QueryWrapper<DailyReport> dailyReportQueryWrapper = new QueryWrapper<>();
        dailyReportQueryWrapper.eq("user_id", id);
        int dailyReport = dailyReportMapper.selectCount(dailyReportQueryWrapper);

        // 获取周报数
        QueryWrapper<WeeklyReport> weeklyReportQueryWrapper = new QueryWrapper<>();
        weeklyReportQueryWrapper.eq("user_id", id);
        int weeklyReport = weeklyReportMapper.selectCount(weeklyReportQueryWrapper);

        // 封装信息
        return new MonitorMessage((String) id, like, discussArticle, assignment,
                assignmentGit, gitLog, userTopic, plan, dailyReport, weeklyReport);
    }
}
