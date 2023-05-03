package com.company.config;

import org.springframework.context.annotation.*;
import springfox.documentation.builders.*;
import springfox.documentation.service.*;
import springfox.documentation.spi.*;
import springfox.documentation.spring.web.plugins.*;
import springfox.documentation.swagger2.annotations.*;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket postApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("sms sender")
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Sms Sender")
                .description("Sending sms using twilio")
                .build();
    }
}
