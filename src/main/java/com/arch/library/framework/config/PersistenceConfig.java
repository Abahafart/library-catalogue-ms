package com.arch.library.framework.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = {"com.arch.library.framework.output.persistence.data"})
@EnableJpaRepositories(basePackages = {"com.arch.library.framework.output.persistence.repository"})
public class PersistenceConfig {

}
