package br.com.bb.exemplo.springdemo.config;

import br.com.bb.exemplo.springdemo.client.ExternalUser;
import br.com.bb.exemplo.springdemo.client.UserClient;
import br.com.bb.exemplo.springdemo.models.User;
import br.com.bb.exemplo.springdemo.repository.UserRepository;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class DBConfiguration {
    private final UserClient userClient;
    private final UserRepository userRepository;

    public DBConfiguration(UserClient userClient, UserRepository userRepository) {
        this.userClient = userClient;
        this.userRepository = userRepository;
    }

//    @PostConstruct
//    void initDB() {
//        for (ExternalUser externalUser : this.userClient.getAllExternalClients().getUsers()) {
//            User user = new User();
//            user.setFirstName(externalUser.getFirstName());
//            user.setLastName(externalUser.getLastName());
//            user.setAge(externalUser.getAge());
//            user.setEmail(externalUser.getEmail());
//
//            this.userRepository.save(user);
//        }
//    }

}
