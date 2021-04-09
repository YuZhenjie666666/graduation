package com.zut.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfigration implements WebMvcConfigurer {
//    这是解决跨域问题的配置文件
    @Override
    public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")
            .allowedOriginPatterns("*")
            .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
            .allowCredentials(true)
            .maxAge(3600);
}

}
