package com.inet.entity.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/17 11:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonitorMessage {

    /**
     * 用户id
     */
    private String id;

    /**
     * 点赞的文章数
     */
    private Integer like;

    /**
     * 评论的文章数
     */
    private Integer discussArticle;

    /**
     * 应完成的任务数
     */
    private Integer assignment;

    /**
     * 实际完成的任务数
     */
    private Integer assignmentGit;

    /**
     * 提交的算法题数
     */
    private Integer gitLog;

    /**
     * 通过审核的算法题数
     */
    private Integer userTopic;

    /**
     * 用户计划
     */
    private Integer plan;

    /**
     * 日报数
     */
    private Integer dailyReport;

    /**
     * 周报数
     */
    private Integer weeklyReport;
}
