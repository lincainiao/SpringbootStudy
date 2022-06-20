package com.lin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.io.File;

@Configuration
public class FileUploadConfig {
    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        commonsMultipartResolver.setDefaultEncoding("utf-8");
        commonsMultipartResolver.setMaxUploadSize(104857600);
        commonsMultipartResolver.setMaxInMemorySize(40960);
        return commonsMultipartResolver;
    }
}
