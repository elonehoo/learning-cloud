package com.inet.code.entity.vo;

import lombok.Data;

/**
 * 题目展示类
 * @author: hlj
 * @date: 2021-06-05
*/
@Data
public class TopicVO {
    private String title;
    private String author;
    private Integer level;
    private String content;
}
