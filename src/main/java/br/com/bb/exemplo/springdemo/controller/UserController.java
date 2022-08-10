package br.com.bb.exemplo.springdemo.controller;

import br.com.bb.exemplo.springdemo.UserDTO;
import br.com.bb.exemplo.springdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.bb.exemplo.springdemo.models.User;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<UserDTO> getUsers() {
        return this.userService.getAllUsers().stream()
                .map(user -> new UserDTO(user.getEmail(), user.getFirstName(), user.getLastName(), user.getCpf()))
                .collect(Collectors.toList());
    }

   @GetMapping("/{id}")
   public UserDTO getUser(@Valid @PathVariable Long id) {
       return this.userService.getById(id)
               .map(user -> new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail(), user.getCpf()))
               .orElseThrow();
   }

//    @GetMapping("/paginated")
//    public Page<UserDTO> getUsersPaginated(Pageable pageable) {
//        return this.userService.getAllUsersPaginated(pageable)
//                .map(user -> new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail()));
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> userUpdate(@Valid @PathVariable(value = "id") long id, @RequestBody User user){
        user.setId(id);
        userService.saveNewUserToDB(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping
    public User createNewUser(@Valid @RequestBody User user) {
        LOGGER.warn("USER CREATED ::" + user);
        return userService.saveNewUserToDB(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        LOGGER.warn("USER Deleted :: " );
        userService.deleteUser(id);
    }
}