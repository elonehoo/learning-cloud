package com.inet.code.mapper;

import com.inet.code.entity.user.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表
 Mapper 接口
 * </p>
 *
 * @author HCY
 * @since 2021-05-08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
