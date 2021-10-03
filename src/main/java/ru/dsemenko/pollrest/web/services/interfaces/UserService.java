package ru.dsemenko.pollrest.web.services.interfaces;

import ru.dsemenko.pollrest.web.models.auth.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getByUsername(String username);
    User getByEmail(String email);
    void save(User user);
    void update(User user);
    void delete(Long id);
}
