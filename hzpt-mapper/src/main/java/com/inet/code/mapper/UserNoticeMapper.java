package com.inet.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.inet.code.entity.userNotice.po.UserNotice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/17 14:10
 */
@Mapper
public interface UserNoticeMapper extends BaseMapper<UserNotice> {
}