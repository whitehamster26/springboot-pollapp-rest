package ru.dsemenko.pollrest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dsemenko.pollrest.web.security.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
