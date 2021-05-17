package com.inet.code.service.impl;

import com.inet.code.lang.Result;
import com.inet.code.service.GetNoticeService;
import com.inet.code.service.NoticeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ Author     ：YRS
 * @ Date       ：Created in 9:14 2021/5/13
 * @ Description：获取通知通
 */
@Service
public class GetNoticeServiceImpl implements GetNoticeService {

    @Resource
    private NoticeService noticeService;

    @Override
    public Result getByID(String id) {
        return Result.success(noticeService.getById(id));
    }

    @Override
    public Result getAllNotice() {
        return Result.success(noticeService.list());
    }
}
