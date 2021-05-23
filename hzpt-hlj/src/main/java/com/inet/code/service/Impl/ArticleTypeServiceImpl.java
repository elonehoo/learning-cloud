package com.inet.code.service.Impl;

import com.inet.code.entity.po.ArticleType;
import com.inet.code.mapper.ArticleTypeMapper;
import com.inet.code.service.ArticleTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文章类型关系服务层
 * @author: hlj
 * @date: 2021-05-17
*/
@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Resource
    ArticleTypeMapper articleTypeMapper;

    @Override
    public boolean insertArticleType(ArticleType articleType) {
        int row = articleTypeMapper.insertArticleType(articleType);
        return row>=1;
    }
}
