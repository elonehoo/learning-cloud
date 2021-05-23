package com.inet.code.mapper;

import com.inet.code.entity.po.Article;
import com.inet.code.entity.vo.ShowArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 文章数据库操作
 * @author: hlj
 * @date: 2021-05-17
*/
@Mapper
public interface ArticleMapper {
    /**
     * 新增文章
     * @param article 对应数据库文章表字段
     * @return int 返回插入成功行数
    */
    int insertArticle(Article article);

    /**
     * 根据文章类型与选择的排序依据进行排序并返回一个 list
     * @param articleTypeId 文章类型
     * @param sortBy 排序依据
     * @return List<ShowArticleVO> 文章展示类集合
     */
    List<ShowArticleVO> selectArticle(String articleTypeId, String sortBy);
}
