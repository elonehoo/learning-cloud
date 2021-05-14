package com.inet.code.entity.discussArticle.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.*;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文章评论表

 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("milc_discuss_article")
public class DiscussArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键(UUID)
     */
    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    @Excel(name = "id")
    private String id;

    /**
     * 用户id(UUID)
     */
    @TableField("user_id")
    @Excel(name = "user_id")
    private String userId;

    /**
     * 文章id(UUID)
     */
    @TableField("article_id")
    @Excel(name = "article_id")
    private String articleId;

    /**
     * 评论的父评论的id(UUID)
     */
    @TableField("parent_id")
    @Excel(name = "parent_id")
    private String parentId;

    /**
     * 评论内容
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
    private LocalDateTime gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Excel(name = "gmt_modified", format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModify;


}
