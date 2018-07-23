package com.example.demo.restcontroller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        Collection<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> findOne(@PathVariable("userId") Long userId) {
        User user = userService.findOne(userId);
        return ResponseEntity.ok(user);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        user = userService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<?> update(@PathVariable("userId") Long userId, @RequestBody User user) {
        user.setId(userId);

        user = userService.update(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> delete(@PathVariable("userId") Long userId) {
        userService.delete(userId);
        return ResponseEntity.ok("");
    }
}
