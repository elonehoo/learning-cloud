package com.inet.code.service;

import com.inet.code.lang.Result;

/**
 * @ Author     ：YRS
 * @ Date       ：Created in 14:38 2021/5/11
 * @ Description：获取通知
 */
public interface GetNoticeService {
    /**
     * 根据通知id获取通知
     * @param id
     * @return Result
     */
    public Result getByID(String id);

    /**
     * 获取所有通知
     * @return  Result
     */
    public Result getAllNotice();
}
