package toomuchdrinking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "toomuchdrinking")
public class AppConfig {

    @Autowired
    private JdbcTemplate template;

    /*
    @Autowired
    private ConsumedBeersRepository repository;

    @Bean
    public JdbcTemplate template() {
        return template;
    }

    @Bean
    public ConsumedBeersRepository repository() {
        return repository;
    }*/

}
