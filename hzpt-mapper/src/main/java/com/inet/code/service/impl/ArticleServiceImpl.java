package com.inet.code.service.impl;

import com.inet.code.entity.atricle.po.Article;
import com.inet.code.mapper.ArticleMapper;
import com.inet.code.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表
 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
