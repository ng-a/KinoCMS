package com.example.kinocms.config;


import com.example.kinocms.converters.GenderConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
//                .addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");

    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new GenderConverter());
    }
}
