package com.inet.code.mapper;

import com.inet.code.entity.articleType.po.ArticleType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章类型关系表
 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Mapper
public interface ArticleTypeMapper extends BaseMapper<ArticleType> {

}
