package com.inet.code.service.Impl;

import com.inet.code.entity.dto.ArticleDTO;
import com.inet.code.entity.po.Article;
import com.inet.code.entity.po.ArticleType;
import com.inet.code.entity.vo.ShowArticleVO;
import com.inet.code.mapper.ArticleMapper;
import com.inet.code.service.ArticleService;
import com.inet.code.service.ArticleTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 文章服务层
 * @author: hlj
 * @date: 2021-05-17
*/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleMapper articleMapper;

    @Resource
    ArticleTypeService articleTypeService;


    @Override
    public boolean saveArticle(ArticleDTO articleDTO) {
        String articleId = UUID.randomUUID().toString();
        int articleRow = articleMapper.insertArticle(new Article(articleId,articleDTO.getUserId(),articleDTO.getHeadline(),articleDTO.getL()));
        boolean articleTypeBoolean = articleTypeService.insertArticleType(new ArticleType(articleId,articleDTO.getArticleTypeId()));

        return articleRow>=1 && articleTypeBoolean;
    }

    @Override
    public List<ShowArticleVO> showArticle(String articleTypeId, String sortBy) {
        List<ShowArticleVO> showArticleVOList = articleMapper.selectArticle(articleTypeId,sortBy);

        return showArticleVOList;
    }
}
