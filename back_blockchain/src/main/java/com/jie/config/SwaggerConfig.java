package com.jie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
//@EnableSwagger2
//@EnableOpenApi
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket ( DocumentationType.SWAGGER_2)
                .apiInfo ( apiInfo() )
                .enable ( true )
                .select ()
                .apis( RequestHandlerSelectors.basePackage ( "com.jie.controller" ))
                .paths ( PathSelectors.any () )
                .build ();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder ().version ( "1.0" )
                .description ( "ning lab" )
                .title ( "block chain" )
//                .contact (new springfoxjk ))
                .license ( "none" )
                .build ();
    }

}
