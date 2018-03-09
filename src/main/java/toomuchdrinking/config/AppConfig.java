package toomuchdrinking.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.net.URISyntaxException;

@Configuration
public class AppConfig {

    /*
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {

        System.out.println(System.getenv("JDBC_DATABASE_URL"));
        System.out.println(System.getenv("JDBC_DATABASE_USERNAME"));
        System.out.println(System.getenv("JDBC_DATABASE_PASSWORD"));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(System.getenv("SPRING_JDBC_DATABASE_URL"));
        System.out.println(System.getenv("SPRING_JDBC_DATABASE_USERNAME"));
        System.out.println(System.getenv("SPRING_JDBC_DATABASE_PASSWORD"));

        final DataSourceBuilder dbBuilder = DataSourceBuilder.create();
        dbBuilder.url(System.getenv("JDBC_DATABASE_URL")).password(System.getenv("JDBC_DATABASE_USERNAME")).
                password(System.getenv("JDBC_DATABASE_PASSWORD"));

        return dbBuilder.build();
    }*/

}
