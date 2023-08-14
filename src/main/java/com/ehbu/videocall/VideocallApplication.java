package com.ehbu.videocall;

import com.ehbu.videocall.user.User;
import com.ehbu.videocall.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VideocallApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideocallApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserService userService) {
        return args -> {
            userService.register(User.builder()
                    .username("Ehbu")
                    .email("ehbu@gmail.com")
                    .password("123")
                    .build());

            userService.register(User.builder()
                    .username("Jason")
                    .email("jason@gmail.com")
                    .password("123")
                    .build());

            userService.register(User.builder()
                    .username("Hai")
                    .email("hai@gmail.com")
                    .password("123")
                    .build());
        };
    }
}
