package com.inet.code.entity.dailyReport.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 日报表
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("milc_daily_report")
public class DailyReport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 该日报的ID主键(UUID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @Excel(name = "id")
    private String id;

    /**
     * 所属周报ID
     */
    @TableField("audit_status_id")
    @Excel(name = "audit_status_id")
    private String auditStatusId;

    /**
     * 用户ID
     */
    @TableField("user_id")
    @Excel(name = "user_id")
    private String userId;

    /**
     * 日报审核状态
     */
    @TableField("audit_status")
    @Excel(name = "audit_status")
    private boolean auditStatus;

    /**
     * 日报内容
     */
    @TableField("content")
    @Excel(name = "content")
    private String content;

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
