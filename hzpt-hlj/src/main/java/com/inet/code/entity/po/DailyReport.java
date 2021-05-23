package com.inet.code.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Description: 日报持久层
 * @author: hlj
 * @date: 2021-05-10
*/
@ApiModel("日报持久层")
@Data
public class DailyReport {
    @ApiModelProperty("日报ID")
    private String dailyReportId;
    @ApiModelProperty("该条所属周报ID")
    private String ownershipId;
    @ApiModelProperty("上传日报的用户ID")
    private String userId;
    @ApiModelProperty("日报的审核状态")
    private int auditStatus;
    @ApiModelProperty("日报内容")
    private String content;
    @ApiModelProperty("日报创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("日报最后修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifyTime;

    public DailyReport(String dailyReportId, String userId, int auditStatus, String content) {
        this.dailyReportId = dailyReportId;
        this.userId = userId;
        this.auditStatus = auditStatus;
        this.content = content;
    }
}
