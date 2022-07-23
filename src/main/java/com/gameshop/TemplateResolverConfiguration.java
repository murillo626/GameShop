package com.gameshop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
@Configuration
public class TemplateResolverConfiguration {
    @Bean
    public SpringResourceTemplateResolver templateResolve_0(){
        SpringResourceTemplateResolver resolver = 
                new SpringResourceTemplateResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(0);
        resolver.setCheckExistence(true);
        return resolver;
    }
    
    @Bean
    public SpringResourceTemplateResolver templateResolve_1(){
        SpringResourceTemplateResolver resolver = 
                new SpringResourceTemplateResolver();
        resolver.setPrefix("/templates/cliente/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setOrder(0);
        resolver.setCheckExistence(true);
        return resolver;
    }
}
