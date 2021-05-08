package com.inet.code.entity.topic.po;

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
 * 题目表

 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("milc_topic")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键(UUID)
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 来源URL
     */
    @TableField("origin_url")
    private String originUrl;

    /**
     * 发布者id(UUID)
     */
    @TableField("issuer_user_id")
    private String issuerUserId;

    /**
     * 原作者
     */
    @TableField("author")
    private String author;

    /**
     * 难度(0简单,1中等,2困难)
     */
    @TableField("level")
    private Boolean level;

    /**
     * 标签id(UUID)
     */
    @TableField("label_id")
    private String labelId;

    /**
     * 标题
     */
    @TableField("headline")
    private String headline;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create",fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified",fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtModify;


}
