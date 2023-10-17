package com.nikitaee.springwebapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class CustomDispatcherServlet extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ CustomWebMvcConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
