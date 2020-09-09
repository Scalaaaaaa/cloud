package com.example.gateway.com.example.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @AUthor yiyun
 * @Date 2020-09-04
 * @Description 网关用来转发和  判断是否有权限转发
 * 转发：在配置文件配置转发规则
 * 是否有权限转发：通过约定的/auth/token接口判断入参中的token是否有效，所以 /auth/token一定会配置在转发规则
 */
@EnableWebFluxSecurity
public class ResourceServerConfig {
    /***
     * @Description WebFluxSecurity关键配置-过滤器，过滤掉没权限的请求
     * @Author yiyun
     * @Date 2020/9/4
     */
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        // 这里只开放了 /actuator/** ,  /auth/token接口，用来获取token的，是直接访问的认证服务器，而没有通过gateway转发
        http.csrf().disable().authorizeExchange()
                .pathMatchers("/actuator/**").permitAll()
                // 如果是细节的判断，则代码是.anyExchange().access(authorizationManager)
                // 下面的.anyExchange().authenticated()表示  只要jwt认证通过，则有权限访问所有资源（接口）
                //TODO 后续增加RBAC（Role Based Access Control)控制资源 像第三方应用获取微信头像信息这种需求
                // 可以用jwt的有效时间字段 来控制
                .anyExchange().authenticated();
        // 开启oauth2的资源服务器  和  jwt支持
        // 简单理解，jwt就是在你登陆的时候给你一个令牌，请求资源时带上令牌  后台就能判断你是你
        // oauth2就是  根据jwt令牌里的附加信息（比如角色）来判断你有没有权限访问该资源
        http.oauth2ResourceServer().jwt();
        http.oauth2Login();
        return http.build();
    }
}
