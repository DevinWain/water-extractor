package com.wain.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 跨域请求处理，通过添加跨域请求映射实现
             */
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")  // 为指定路径开启跨域请求处理
                        .allowedOriginPatterns("*") // 允许所有域
                        .allowedMethods("*") // 允许任何方法（post、get等）
                        .allowedHeaders("*") // 允许任何请求头
                        .allowCredentials(true) // 允许证书、cookie
                        .maxAge(3600); // 在3600秒内，不需要再发送预检验请求，可以缓存该结果
            }
        };
    }
}
