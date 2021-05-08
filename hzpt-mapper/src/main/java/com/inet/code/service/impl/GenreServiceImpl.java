package com.inet.code.service.impl;

import com.inet.code.entity.genre.Genre;
import com.inet.code.mapper.GenreMapper;
import com.inet.code.service.GenreService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章类型表
 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Service
public class GenreServiceImpl extends ServiceImpl<GenreMapper, Genre> implements GenreService {

}
