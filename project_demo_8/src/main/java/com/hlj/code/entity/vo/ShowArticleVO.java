package com.hlj.code.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 文章展示类
 * @author: hlj
 * @date: 2021-05-17
*/
@ApiModel("文章展示类")
@Data
public class ShowArticleVO {
    @ApiModelProperty
    private String genreId;
    @ApiModelProperty
    private String headline;
    @ApiModelProperty
    private String l;
    @ApiModelProperty
    private String createTime;

}
