package com.inet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.inet.code.entity.user.po.User;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/11 14:43
 */
public interface UserServer {

    /**
     * 通过id更新用户信息
     *
     * @param user 用户信息
     * @return 是否成功
     */
    boolean updateUserById(User user);

    /**
     * 通过id删除用户信息
     *
     * @param user 用户信息
     * @return 是否成功
     */
    boolean deleteUserById(User user);
}
