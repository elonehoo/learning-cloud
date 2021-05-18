package com.inet.code.entity.userNotice.po;

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
 * @date Created in 2021/5/17 14:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("milc_user_notice")
public class UserNotice {

    private static final long serialVersionUID = 1L;

    /**
     * 主键(UUID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @Excel(name = "id")
    private String id;

    /**
     * 接收通知者id
     */
    @TableField("recipient_user_id")
    @Excel(name = "recipient_user_id")
    private String recipientUserId;

    /**
     * 通知id
     */
    @TableField("notice_id")
    @Excel(name = "notice_id")
    private String noticeId;

    /**
     * 状态
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
