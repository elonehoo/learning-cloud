package com.inet.service;

import com.inet.code.entity.user.po.User;
import com.inet.entity.VO.MonitorMessage;

import java.io.Serializable;
import java.util.List;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/17 12:53
 */
public interface MonitorServer {

    /**
     * 通过userID查询User信息
     */
    List<User> selectAllUser();

    /**
     * 获取监控信息
     */
    MonitorMessage selectMessageById(Serializable id);
}
