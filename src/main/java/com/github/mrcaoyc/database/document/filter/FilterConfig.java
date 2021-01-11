package com.github.mrcaoyc.database.document.filter;

import com.github.mrcaoyc.database.document.service.DatabaseConfigurationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author caoyongcheng
 */
@Configuration
public class FilterConfig implements WebMvcConfigurer {
    private final DatabaseConfigurationService databaseConfigurationService;

    public FilterConfig(DatabaseConfigurationService databaseConfigurationService) {
        this.databaseConfigurationService = databaseConfigurationService;
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(dynamicDataSourceInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public DynamicDataSourceInterceptor dynamicDataSourceInterceptor() {
        return new DynamicDataSourceInterceptor(databaseConfigurationService);
    }
}
