package com.inet.code.entity.assignment.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务表

 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("milc_assignment")
public class Assignment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键(UUID)
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    @Excel(name = "id")
    private String id;

    /**
     * 发送者id(UUID)
     */
    @TableField("sender_user_id")
    @Excel(name = "sender_user_id")
    private String senderUserId;

    /**
     * 接受者id(UUID)(为空发全部)
     */
    @TableField("recipient_user_id")
    @Excel(name = "recipient_user_id")
    private String recipientUserId;

    /**
     * 任务类型id(UUID)
     */
    @TableField("category_id")
    @Excel(name = "category_id")
    private String categoryId;

    /**
     * 标题 
     */
    @TableField("headline")
    @Excel(name = "headline")
    private String headline;

    /**
     * 内容
     */
    @TableField("content")
    @Excel(name = "content")
    private String content;

    /**
     * 开始时间
     */
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "start_time", format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "end_time", format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 状态 
     */
    @TableField("status")
    @Excel(name = "status")
    private Boolean status;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "gmt_create",format = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "gmt_modified",format = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModify;
}
