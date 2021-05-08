package com.inet.code.mapper;

import com.inet.code.entity.genre.Genre;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章类型表
 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Mapper
public interface GenreMapper extends BaseMapper<Genre> {

}
