package com.lin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
// 开启Swagger
@EnableSwagger2
public class SwaggerConfig {
    // 配置swagger docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        // 获取项目环境：dev还是pro
        String profiles = "dev";
        // 通过environment.acceptsProfiles判断是否处在自己设定的环境中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("Lin Mouren")
                // 配置是否开启swagger
               .enable(true)
                .select()
                // RequestHandlerSelectors：配置要扫描接口的方式
                // basePackage：自定义扫描的包
                // any: 全部扫描; none: 不扫描;
                // withClassAnnotation: 扫描类上的注解
                // withMethodAnnotation: 扫描方法上的注解
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .apis(RequestHandlerSelectors.basePackage("com.lin.controller"))
                // paths: 过滤的路径
//                .paths(PathSelectors.ant("/lin/**"))
                .build();
    }

    // 配置多套docket，groupName不能重名
    @Bean
    public Docket docketZhizhi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("zhizhi");
    }
    @Bean
    public Docket docketYtm(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("ytm");
    }
    @Bean
    public Docket docketZsy(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("zsy");
    }

    // 自定义ApiInfo用于替换原来的
    private ApiInfo apiInfo(){
        // 作者信息
        Contact DEFAULT_CONTACT = new Contact("Lin Mouren", "https://space.bilibili.com/34864640?spm_id_from=444.41.0.0", "null");
        return new ApiInfo("Lin Mouren's ApiInfo",
                "Don't give up without changing my phone",
                "1.0", "https://item.jd.com/100026667930.html#crumb-wrap",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "https://item.jd.com/100026667930.html#crumb-wrap",
                new ArrayList<VendorExtension>());
    }
}
