package com.tosloth.toslothserver;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository repository;

    UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<User> getAllUsers() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/users")
    User registerUser(@RequestBody User newUser) {
        if (repository.findUserByNickname(newUser.getNickname()).isEmpty())
            throw new IllegalStateException("User already exists");

        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User replaceUser(@RequestBody User newEmployee, @PathVariable String id) {

        return repository.findById(id)
                .map(employee -> {
                    employee.setNickname(newEmployee.getNickname());
                    employee.setLastname(newEmployee.getLastname());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }
}
