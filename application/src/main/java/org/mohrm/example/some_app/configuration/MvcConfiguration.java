package org.mohrm.example.some_app.configuration;

import org.mohrm.example.some_app.restapi.impl.HelloController;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;


@Configuration
public class MvcConfiguration implements WebMvcConfigurer {

    @Value("${restapi.baseUrl}")
    private String restapiBaseUrl;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.addPathPrefix(restapiBaseUrl,
                HandlerTypePredicate.forAnnotation(RestController.class).and(HandlerTypePredicate.forBasePackageClass(HelloController.class)));
    }

}
