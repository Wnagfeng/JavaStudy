package org.example.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMvCInt extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /*
     * Spring需要的配置类
     * */

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{MVCConfig.class};
    }

    /*
     * Servlet Dispatcher的映射
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
