package com.inet.code.service;

/**
 * 备份
 * @author: hlj
 * @date: 2021-05-23
*/
public interface BackUpsService {
    /**
     * 数据库备份
     * @param password
     * @return boolean 返回备份是否成功
    */
    boolean dbBackUp(String password);
}
