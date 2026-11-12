package kh.edu.istad.restapi.controller;


import kh.edu.istad.restapi.model.User;
import kh.edu.istad.restapi.repository.UserRepository;
import kh.edu.istad.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable UUID id) {
        return userService.getById(id);
    }
    @PostMapping
    public String createUser(@RequestBody User user){
        userRepository.insert(user);
        return"User Created succefully";

    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable UUID id) {

        boolean removed = UserRepository.deleteById(id);

        if (removed) {
            return "User deleted successfully!";
        }

        return "User not found!";
    }

}
