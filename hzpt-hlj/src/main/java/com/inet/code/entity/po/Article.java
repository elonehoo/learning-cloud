package com.inet.code.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 文章持久层
 * @author: hlj
 * @date: 2021-05-17
*/
@ApiModel("文章持久层")
public class Article {
    @ApiModelProperty("文章ID")
    private String articleId;
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("文章标题")
    private String headline;
    @ApiModelProperty("文章内容")
    private String l;
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @ApiModelProperty("修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    public Article(String articleId, String userId, String headline, String l) {
        this.articleId = articleId;
        this.userId = userId;
        this.headline = headline;
        this.l = l;
    }
}
