package com.hlj.code.entity.po;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 文章类型持久层
 * @author: hlj
 * @date: 2021-05-17
*/
public class ArticleType {
    private String articleId;
    private String genreId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    public ArticleType(String articleId, String genreId) {
        this.articleId = articleId;
        this.genreId = genreId;
    }
}
