package com.castilho.workshopmongo.config;

import com.castilho.workshopmongo.domain.User;
import com.castilho.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        List<User> list = new ArrayList<>();
        list.add(new User(null, "Maria Brown", "maria@gmail.com"));
        list.add(new User(null, "Alex Green", "alex@gmail.com"));
        list.add(new User(null, "Bob Grey", "bob@gmail.com"));

        for (User user: list) {
            userRepository.save(user);
        }
    }
}
