package com.educandoweb.course.config;

import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepositories;

    @Override
    public void run(String... args) throws Exception {
//        User u1 = new User( "Maria Brown", "maria@gmail.com", "988888888", "123456");
//        User u2 = new User( "Alex Green", "alex@gmail.com", "977777777", "123456");

        System.out.println(Instant.parse("2019-06-20T19:53:07Z"));
//        userRepositories.saveAll(Arrays.asList(u1,u2));
    }

}
