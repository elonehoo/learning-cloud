package com.inet.service.impl;

import com.inet.code.entity.notice.po.Notice;
import com.inet.code.entity.userNotice.po.UserNotice;
import com.inet.code.mapper.NoticeMapper;
import com.inet.code.mapper.UserNoticeMapper;
import com.inet.entity.DTO.NoticeDTO;
import com.inet.service.NoticeServer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/17 13:47
 */
@Service
public class NoticeServerImpl implements NoticeServer {

    private final NoticeMapper noticeMapper;
    private final UserNoticeMapper userNoticeMapper;

    /**
     * 自动注入
     */
    public NoticeServerImpl(NoticeMapper noticeMapper, UserNoticeMapper userNoticeMapper) {
        this.noticeMapper = noticeMapper;
        this.userNoticeMapper = userNoticeMapper;
    }

    /**
     * 发送通知
     */
    @Override
    public int sendNotice(NoticeDTO noticeDTO) {
        // 生成通知id
        String noticeId = UUID.randomUUID().toString();

        // 封装通知信息
        Notice notice = new Notice();

        notice.setId(noticeId);
        notice.setSenderUserId(noticeDTO.getSenderUserId());
        notice.setHeadline(noticeDTO.getHeadline());
        notice.setContent(noticeDTO.getContent());
        notice.setAccessoryUrl(noticeDTO.getAccessoryUrl());
        notice.setGmtCreate(new Date());
        notice.setGmtModify(new Date());

        // 封装用户通知信息
        UserNotice userNotice = new UserNotice();

        userNotice.setId(UUID.randomUUID().toString());
        userNotice.setRecipientUserId(noticeDTO.getRecipientUserId());
        userNotice.setNoticeId(noticeId);
        userNotice.setStatus(noticeDTO.getStatus());
        userNotice.setGmtCreate(new Date());
        userNotice.setGmtModify(new Date());

        int result;
        result = noticeMapper.insert(notice);
        result += userNoticeMapper.insert(userNotice);

        return result;
    }
}
