package com.inet.code.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
/**
 * 题目持久层
 * @author: hlj
 * @date: 2021-06-06
*/
@ApiModel("日报持久层")
@Data
public class Topic {
    @ApiModelProperty("题目ID")
    private String id;
    @ApiModelProperty("来源URL")
    private String originUrl;
    @ApiModelProperty("发布者id(UUID)")
    private String issuerUserId;
    @ApiModelProperty("原作者")
    private String author;
    @ApiModelProperty("难度(0简单,1中等,2困难)")
    private int level;
    @ApiModelProperty("标签id(UUID)")
    private String labelId;
    @ApiModelProperty("标题")
    private String headline;
    @ApiModelProperty("内容")
    private String content;
    @ApiModelProperty("状态")
    private int status;
    @ApiModelProperty("日报创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("日报最后修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public Topic(String id, String originUrl, String issuerUserId, String author, int level, String labelId, String headline, String content) {
        this.id = id;
        this.originUrl = originUrl;
        this.issuerUserId = issuerUserId;
        this.author = author;
        this.level = level;
        this.labelId = labelId;
        this.headline = headline;
        this.content = content;
    }
}
