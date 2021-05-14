package com.inet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.inet.code.entity.user.po.User;
import com.inet.code.mapper.UserMapper;
import com.inet.code.service.*;
import com.inet.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/11 14:45
 */
@Service
@Transactional(rollbackFor = {RuntimeException.class})
public class UserServerImpl extends ServiceImpl<UserMapper, User> implements UserServer {

    private CipherService cipherService;
    private UserRoleService userRoleService;

    /**
     * 自动注入bean
     */
    @Autowired
    public void setUserServiceImpl(CipherService cipherService, UserRoleService userRoleService) {
        this.cipherService = cipherService;
        this.userRoleService = userRoleService;
    }

    /**
     * 更新用户信息
     *
     * @param user 用户信息
     * @return 是否成功
     */
    @Override
    public boolean updateUserById(User user) {
        user.setGmtModify(new Date());
        return this.updateById(user);
    }

    /**
     * 删除用户
     *
     * @param user 用户信息
     * @return 是否成功
     */
    @Override
    public boolean deleteUserById(User user) {
        if (!this.removeById(user.getId())) {
            throw new RuntimeException("删除user失败！");
        }

        Map<String, Object> cipherMap = new HashMap<>(1);
        cipherMap.put("account", user.getAccount());

        if (!cipherService.removeByMap(cipherMap)) {
            throw new RuntimeException("删除cipher失败！");
        }

        Map<String, Object> userIdMap = new HashMap<>(1);
        userIdMap.put("user_id", user.getId());

        if (!userRoleService.removeByMap(userIdMap)) {
            throw new RuntimeException("删除userRole失败！");
        }
        return true;
    }
}