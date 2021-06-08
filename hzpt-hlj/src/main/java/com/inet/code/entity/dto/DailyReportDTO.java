package com.inet.code.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description: 日报传输类
 * @author: hlj
 * @date: 2021-05-10
*/
@ApiModel("日报传输类")
@Data
public class DailyReportDTO {
    @ApiModelProperty("用户ID")
    private String userId;
    @ApiModelProperty("日报内容")
    private String content;

}
