package com.inet.code.service.impl;

import com.inet.code.entity.category.po.Category;
import com.inet.code.mapper.CategoryMapper;
import com.inet.code.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务类型表
 服务实现类
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
