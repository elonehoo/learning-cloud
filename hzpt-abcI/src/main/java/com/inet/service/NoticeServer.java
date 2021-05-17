package com.inet.service;

import com.inet.code.entity.notice.po.Notice;
import com.inet.entity.DTO.NoticeDTO;

import java.io.Serializable;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/17 13:47
 */
public interface NoticeServer {

    int sendNotice(NoticeDTO noticeDTO);

}
