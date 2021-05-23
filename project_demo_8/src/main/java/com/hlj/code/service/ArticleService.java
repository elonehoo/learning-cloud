package com.hlj.code.service;

import com.hlj.code.entity.dto.ArticleDTO;
import com.hlj.code.entity.vo.ShowArticleVO;

import java.util.List;

/**
 * 文章服务层
 * @author: hlj
 * @date: 2021-05-17
*/
public interface ArticleService {
    /**
     * 上传一篇包含文章类型的文章
     * @param articleDTO 新增文章传输类
     * @return string 返回数据库操作信息
    */
    boolean saveArticle(ArticleDTO articleDTO);

    /**
     * 根据文章类型与选择的排序依据进行排序并返回一个 list
     * @param articleTypeId 文章类型
     * @param sortBy 排序依据
     * @return List<ShowArticleVO> 文章展示类集合
    */
    List<ShowArticleVO> showArticle(String articleTypeId, String sortBy);
}
