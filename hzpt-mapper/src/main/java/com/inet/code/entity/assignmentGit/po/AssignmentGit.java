package com.inet.code.entity.assignmentGit.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/17 12:31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("milc_assignment_git")
public class AssignmentGit {

    private static final long serialVersionUID = 1L;

    /**
     * 主键(UUID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @Excel(name = "id")
    private String id;

    /**
     * 任务id
     */
    @TableField("assignment_id")
    @Excel(name = "assignment_id")
    private String assignmentId;

    /**
     * 接收者id
     */
    @TableField("recipient_user_id")
    @Excel(name = "recipient_user_id")
    private String recipientUserId;

    /**
     * 任务内容
     */
    @TableField("content")
    @Excel(name = "content")
    private String content;

    /**
     * 任务提交状态
     */
    @TableField("status")
    @Excel(name = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "gmt_create", format = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "gmt_modified", format = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModify;
}
