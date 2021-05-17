package com.inet.entity.DTO;

import lombok.Data;

/**
 * @author Li
 * @version 1.0
 * @date Created in 2021/5/17 13:52
 */
@Data
public class NoticeDTO {
    private String senderUserId;
    private String headline;
    private String content;
    private String accessoryUrl;
    private String recipientUserId;
    private Integer status;
}
