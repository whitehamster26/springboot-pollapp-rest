package ru.dsemenko.pollrest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dsemenko.pollrest.web.models.auth.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    User findByUsername(String username);
}
