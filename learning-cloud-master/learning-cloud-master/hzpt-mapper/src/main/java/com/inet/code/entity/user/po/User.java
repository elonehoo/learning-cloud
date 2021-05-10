package com.inet.code.entity.user.po;

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
 * 用户表

 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("milc_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键(UUID) 
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 真实姓名
     */
    @TableField("name")
    private String name;

    /**
     * 账号(唯一) 
     */
    @TableField("account")
    private String account;

    /**
     * 工号/学号(唯一)
     */
    @TableField("student_id")
    private String studentId;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 手机号码 
     */
    @TableField("mobile_no")
    private String mobileNo;

    /**
     * 头像URL
     */
    @TableField("avator_url")
    private String avatorUrl;

    /**
     * 性别
     */
    @TableField("sex")
    private Integer sex;

    /**
     * 生日
     */
    @TableField("birthday")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date birthday;

    /**
     * 个人简介
     */
    @TableField("remark")
    private String remark;

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
