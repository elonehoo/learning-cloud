package com.inet.code.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Description: 周报展示类
 * @author: hlj
 * @date: 2021-05-10
 */
@ApiModel("周报展示类")
@Data
public class WeeklyReportVO {
    @ApiModelProperty("周报ID")
    private String weeklyReportId;
    @ApiModelProperty("上传日报的用户ID")
    private String userId;
    @ApiModelProperty("周报的审核状态")
    private Integer auditStatus;
    @ApiModelProperty("该周报的子日报集")
    private List<String> listDailyReportContent;
    @ApiModelProperty("周报内容")
    private String content;
    @ApiModelProperty("周报创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("周报最后修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifyTime;
}
