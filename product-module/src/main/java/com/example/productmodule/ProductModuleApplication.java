package com.example.productmodule;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
// 开启dubbo注解，主要是  @Service(dubbo的service，不是spring的）  和 @Referance,前者是暴露服务，后者是调用服务
@EnableDubbo
public class ProductModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductModuleApplication.class, args);
    }

}
