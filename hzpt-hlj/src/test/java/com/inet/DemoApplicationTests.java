package com.inet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
    @Value("${spring.datasource.url}")
    String url;
    @Test
    void contextLoads() {
        System.out.println(url);
        System.out.println(url.indexOf("//",1));
        System.out.println(url.lastIndexOf("/"));
        String hostAndPort =url.substring(url.indexOf("//")+2,url.lastIndexOf("/"));
        String host = hostAndPort.substring(0,hostAndPort.indexOf(":"));
        String post = hostAndPort.substring(hostAndPort.indexOf(":")+1);
        System.out.println(post);
        System.out.println(host);
    }

}
