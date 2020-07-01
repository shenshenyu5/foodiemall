package com.imooc.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    //实现静态资源的映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //映射本地静态资源
        registry.addResourceHandler("/**")
                //映射swagger2
                .addResourceLocations("classpath:/META-INF/resource/")
                .addResourceLocations("file:/workspace/images/");
    }
}
