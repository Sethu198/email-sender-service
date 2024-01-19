package com.example.mailSender.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class ApiConfiguration {
    @Primary
    @Bean
    public FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean(){
    FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean=new FreeMarkerConfigurationFactoryBean();
    freeMarkerConfigurationFactoryBean.setTemplateLoaderPath("classpath:/templates");
    return freeMarkerConfigurationFactoryBean;

}

}
