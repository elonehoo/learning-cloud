package com.inet.code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfig
 * @author hlj
 * @since 2021/04/21
 */
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30).pathMapping("/")
                // 开启个人信息
                .apiInfo(apiInfo())
                // 选择哪些接口作为swagger的doc发布
                .select()
                .build();
    }

    /**
     * 个人信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //api文本
                .title("某墨 api")
                //说明
                .description("更多请不要咨询某墨")
                //用户名 + 网址 + 邮箱
                .contact(new Contact("某墨" ,
                        "https://github.com/Heioi-10" ,
                        "3165656649@qq.com"))
                //版本
                .version("2.0")
                //运行
                .build();
    }
}
