package ru.dsemenko.pollrest.web.services.interfaces;

import ru.dsemenko.pollrest.web.security.models.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getByName(String name);
    void save(Role role);
    void delete(Long id);
}
