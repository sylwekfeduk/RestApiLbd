package pl.fis.lbd.restapi.RestApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Rest API LBD")
                .description("Restowe API na potrzeby projektu LBD")
                .build();
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                .paths(PathSelectors.any())
                .build();
    }
}
