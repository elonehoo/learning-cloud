package com.inet.code.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增文章传输类
 * @author: hlj
 * @date: 2021-05-17
*/
@ApiModel("新增文章传输类")
@Data
public class ArticleDTO {
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("文章标题")
    private String headline;
    @ApiModelProperty("文章内容")
    private String l;
    @ApiModelProperty("文章类型ID")
    private String articleTypeId;

}
