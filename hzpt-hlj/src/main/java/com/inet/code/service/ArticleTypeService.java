package com.inet.code.service;

import com.inet.code.entity.po.ArticleType;

/**
 * 文章类型关系服务层
 * @author: hlj
 * @date: 2021-05-17
*/
public interface ArticleTypeService {
    /**
     * 新增文章类型关系
     * @param articleType 对应数据库文章类型关系表字段
     * @return boolean 返回数据库操作是否成功
    */
    boolean insertArticleType(ArticleType articleType);
}
