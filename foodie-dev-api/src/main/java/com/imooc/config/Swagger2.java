package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     *     配置swagger2核心配置 docket
     */
    @Bean
    public Docket createRestApi() {
        //指定api类型为swagger2
        return  new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select().apis(RequestHandlerSelectors
                        //指定controller包
                        .basePackage("com.imooc.controller"))
                        .paths(PathSelectors.any())
                        .build();
    }
    private ApiInfo apiInfo() {
        //文档页标题
        return  new ApiInfoBuilder().title("接口api")
                //联系人信息
                .contact(new Contact("George","test","111@136.com"))
                .description("项目的接口api")
                .version("v0.0.1")
                //网站地址
                .termsOfServiceUrl("baidu.com")
                .build();
    }
}
