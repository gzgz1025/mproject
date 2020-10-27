package com.example.mproject.swagger.config;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //说明这是一个配置类
@EnableSwagger2 // 该注解开启Swagger2的自动配置
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("mproject")
                .apiInfo(getApiInfo())
                .select()
                //设置basePackage会将包下的所有被@Api标记类的所有方法作为api
                .apis(RequestHandlerSelectors.basePackage("com.example.mproject.swagger.controller"))
                //只有标记了@ApiOperation的方法才会暴露出给swagger
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.regex("/api/.*")).build();
    }

    private ApiInfo getApiInfo(){
        return new ApiInfoBuilder()
                .title("API接口文档")
                .description("swagger2 demo api")
                .termsOfServiceUrl("http://localhost:8080/swagger-ui.html")
                .version("1.0")
                .contact(new Contact("Kiana", "http://localhost:8080/swagger-ui.html", "wwssyyzzcc@qq.com"))
                .build();
    }

}
