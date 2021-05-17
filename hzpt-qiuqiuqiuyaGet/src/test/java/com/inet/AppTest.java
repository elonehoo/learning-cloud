package com.inet;


import com.inet.code.service.GetNoticeService;
import com.inet.code.service.NoticeService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {


    @Resource
    private GetNoticeService getNoticeService;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        //System.out.println(getNoticeService.getTest("1"));
        System.out.println(getNoticeService.getAllNotice());
    }
}
