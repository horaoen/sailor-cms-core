package com.horaoen.sailor.autoconfigure.configuration;

import com.horaoen.sailor.autoconfigure.interceptor.AuthorizeInterceptor;
import com.horaoen.sailor.core.token.DoubleJWT;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author horaoen
 */
@Configuration
@EnableConfigurationProperties(SailorCmsProperties.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SailorCmsConfiguration {
    private final SailorCmsProperties properties;

    public SailorCmsConfiguration(SailorCmsProperties properties) {
        this.properties = properties;
    }

    @Bean
    public DoubleJWT jwter() {
        String secret = properties.getTokenSecret();
        Long accessExpire = properties.getTokenAccessExpire();
        Long refreshExpire = properties.getTokenRefreshExpire();
        if (accessExpire == null) {
            // 一个小时
            accessExpire = 60 * 60L;
        }
        if (refreshExpire == null) {
            // 一个月
            refreshExpire = 60 * 60 * 24 * 30L;
        }
        return new DoubleJWT(secret, accessExpire, refreshExpire);
    }

    @Bean
    public AuthorizeInterceptor authInterceptor() {
        String[] excludeMethods = properties.getExcludeMethods();
        return new AuthorizeInterceptor(excludeMethods);
    }
}
