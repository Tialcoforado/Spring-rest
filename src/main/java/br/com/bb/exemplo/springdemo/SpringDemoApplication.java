package br.com.bb.exemplo.springdemo;

import br.com.bb.exemplo.springdemo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringDemoApplication {
    private final Logger LOGGER = Logger.getLogger(UserRepository.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadDB(UserRepository userRepository) throws Exception {
        return (args) -> {
            LOGGER.info("new info");
            System.out.println("LoadDB!!!");
        };
    }
}
