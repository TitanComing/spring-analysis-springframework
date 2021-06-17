package org.peng.mvc.controller;

import org.peng.mvc.base.SignInRequest;
import org.peng.mvc.base.User;
import org.peng.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by peng on 2021/6/17.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> users() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User user(@PathVariable("id") long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/signin")
    public Map<String, Object> signin(@RequestBody SignInRequest signinRequest) {
        try {
            User user = userService.signin(signinRequest.getEmail(), signinRequest.getPassword());
            Map<String, Object> map = new HashMap<>();
            map.put("user", user);
            return map;
        } catch (Exception e) {
            Map<String, Object> map = new HashMap<>();
            map.put("error", "SIGNIN_FAILED");
            map.put("message", e.getMessage());
            return map;
        }
    }

}
