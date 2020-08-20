package br.com.felipesilva.postgres.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("br.com.felipesilva.postgres.repository")
@EntityScan("br.com.felipesilva")
@Configuration
public class JpaRepositoryConfig {
}
