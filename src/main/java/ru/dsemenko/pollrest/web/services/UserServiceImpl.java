package ru.dsemenko.pollrest.web.services;

import org.springframework.stereotype.Service;
import ru.dsemenko.pollrest.web.models.auth.User;
import ru.dsemenko.pollrest.web.repositories.UserRepository;
import ru.dsemenko.pollrest.web.services.interfaces.UserService;
import ru.dsemenko.pollrest.web.services.validators.UserValidator;
import ru.dsemenko.pollrest.web.utils.validators.exceptions.ValidatorException;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserValidator userValidator;

    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userValidator = userValidator;
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        try {
            userValidator.validate(user);
            userRepository.save(user);
        } catch (ValidatorException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void update(User user) {
        try {
            userValidator.validate(user);
            userRepository.save(user);
        } catch (ValidatorException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
