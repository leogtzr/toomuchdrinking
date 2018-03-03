package toomuchdrinking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = {"toomuchdrinking", "toomuchdrinking.controller", "toomuchdrinking.repository"})
public class AppConfig {

    @Autowired
    private JdbcTemplate template;

    @Bean
    public JdbcTemplate template() {
        return template;
    }

}
