package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan("org.example.json")
public class MVCConfig {

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter() {
        RequestMappingHandlerAdapter adapter = new RequestMappingHandlerAdapter();
        adapter.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return adapter;
    }
    //    @Bean
    //    public RequestMappingHandlerMapping handlerMapping(){
    //       return  new RequestMappingHandlerMapping();
    //    }
    //
    //    @Bean
    //    public RequestMappingHandlerAdapter handlerAdapter(){
    //        return  new RequestMappingHandlerAdapter();
    //    }

}
