package com.inet.code.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 题目标签关系持久层
 * @author: hlj
 * @date: 2021-06-06
*/
@ApiModel("题目标签关系持久层")
@Data
public class TopicLabel {
    @ApiModelProperty("id(UUID)")
    private String id;
    @ApiModelProperty("题目id(UUID)")
    private String topicId;
    @ApiModelProperty("标签id(UUID)")
    private String labelId;
    @ApiModelProperty("日报创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @ApiModelProperty("日报最后修改时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

    public TopicLabel(String id, String topicId, String labelId) {
        this.id = id;
        this.topicId = topicId;
        this.labelId = labelId;
    }
}
