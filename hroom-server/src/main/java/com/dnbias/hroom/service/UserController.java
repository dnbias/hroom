package com.dnbias.hroom.service;

import com.dnbias.hroom.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/users")
    public User saveUser(@Valid @RequestBody User user)
    {
        return service.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> fetchUserList()
    {
        return service.fetchUserList();
    }

    // Update operation
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user,
                           @PathVariable("id") Long userId)
    {
        return service.updateUser(user, userId);
    }

    // Delete operation
    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable("id") Long userId)
    {
        service.deleteUserById(userId);
        return "Deleted Successfully";
    }
}
