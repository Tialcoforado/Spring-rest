package br.com.bb.exemplo.springdemo.service;

import br.com.bb.exemplo.springdemo.models.User;
import br.com.bb.exemplo.springdemo.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User saveNewUserToDB(User user){
        return userRepository.save(user);
    }

    public Page<User> getAllUsersPaginated(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    public Optional<User> getById(Long id) {
        return this.userRepository.findById(id);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
