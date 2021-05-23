package com.inet.code.mapper;

import com.inet.code.entity.po.ArticleType;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章类型关系数据操作
 * @author: hlj
 * @date: 2021-05-17
*/
@Mapper
public interface ArticleTypeMapper {
    /**
     * 新增文章类型关系
     * @param articleType 对应数据库文章类型关系表字段
     * @return int 返回插入成功行数
    */
    int insertArticleType(ArticleType articleType);
}
