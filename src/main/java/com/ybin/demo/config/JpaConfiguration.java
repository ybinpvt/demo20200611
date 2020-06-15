package com.ybin.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/12 13:02
 * Jpa配置类
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.ybin.demo.**.repository")
@EnableTransactionManagement(proxyTargetClass = true)
@EntityScan(basePackages = "com.ybin.demo.**.entity")
@Order(Ordered.HIGHEST_PRECEDENCE)//?
public class JpaConfiguration {
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
