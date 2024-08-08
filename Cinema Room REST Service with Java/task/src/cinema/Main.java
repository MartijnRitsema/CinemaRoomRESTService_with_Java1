package cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    // Main class to start the Spring Boot application
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // Bean to create and initialize a Cinema object
    @Bean
    public Cinema cinema() {
        return new Cinema(9, 9);
    }
}
