package com.inet.code.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 题目传输类
 * @author: hlj
 * @date: 2021-06-06
*/
@ApiModel("题目传输类")
@Data
public class TopicDTO {
    @ApiModelProperty(value = "来源",example = "https://leetcode-cn.com")
    private String originUrl;
    @ApiModelProperty(value = "发布者ID",example = "111")
    private String issuerUserId;
    @ApiModelProperty("原作者")
    private String author;
    @ApiModelProperty("题目难度")
    private Integer level;
    @ApiModelProperty("题目标题")
    private String headline;
    @ApiModelProperty("题目内容")
    private String content;

}
