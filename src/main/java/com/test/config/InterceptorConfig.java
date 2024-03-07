package com.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器
 *
 * @author ：niuph
 * @date ：Created in 2022/6/6 10:54
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    /**
     * 是否打开跨域设置
     */
    @Value("${spring.application.corsIntercepter:false}")
    private Boolean cors=false;

    @Bean
    public CorsIntercepter getCorsInterceptor() {
        return new CorsIntercepter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getCorsInterceptor()).addPathPatterns("/**");
    }

}
