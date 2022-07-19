package pl.fis.lbd.restapi.RestApi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.fis.lbd.restapi.RestApi.interceptor.AuthorizeInterceptor;

@Configuration
public class AuthorizeInterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    AuthorizeInterceptor authorizeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizeInterceptor);
    }
}
