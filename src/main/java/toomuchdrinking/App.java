package toomuchdrinking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"toomuchdrinking.repository", "toomuchdrinking.controller"})
public class App {

    public static void main(final String[] args) {
        SpringApplication.run(App.class, args);
    }

}
