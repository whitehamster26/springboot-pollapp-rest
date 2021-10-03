package ru.dsemenko.pollrest.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dsemenko.pollrest.web.models.auth.User;
import ru.dsemenko.pollrest.web.security.models.Role;
import ru.dsemenko.pollrest.web.services.interfaces.RoleService;
import ru.dsemenko.pollrest.web.services.interfaces.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Controller
public class RegistrationController {
    private UserService userService;
    private RoleService roleService;

    public RegistrationController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("registration")
    public String showRegistrationPage(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "registration";
    }

    @PostMapping("registration")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            user.setRoles(new ArrayList<>(Collections.singletonList(roleService.getByName("USER"))));
            userService.save(user);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getCause().getMessage());
            return "registration";
        } catch (Exception e) {
            model.addAttribute("error", "Введены некорректные данные");
            return "registration";
        }
        return "redirect:index";
    }
}
