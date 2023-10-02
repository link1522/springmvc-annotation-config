package com.example.demoAnno;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.example.demoAnno.config.SpringConfig;
import com.example.demoAnno.config.WebConfig;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    // 指定 spring 的配置類
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { SpringConfig.class };
    }

    // 指定 spring mvc 的配置類
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    // 指定 DispatcherServlet 的映射規則，即 url-pattern
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    // 註冊過濾器
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter("UTF-8", true, true);
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[] { characterEncodingFilter, hiddenHttpMethodFilter };
    }
}
