package com.ztlsir.zuul.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 请求进行拦截 验证 accessToken
        http.authorizeRequests()
                //放行
                .antMatchers(
                        //Swagger-网关
                        "/swagger-ui.html",
                        "/*/v2/api-docs/**"
                ).permitAll()
                //拦截其他所有请求
                .anyRequest().authenticated();
    }
}
