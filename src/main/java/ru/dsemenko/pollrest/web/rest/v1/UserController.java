package ru.dsemenko.pollrest.web.rest.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dsemenko.pollrest.web.models.auth.User;
import ru.dsemenko.pollrest.web.services.interfaces.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("list")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("me")
    public User getMyUser(Principal principal) {
        return userService.getByUsername(principal.getName());
    }
}
