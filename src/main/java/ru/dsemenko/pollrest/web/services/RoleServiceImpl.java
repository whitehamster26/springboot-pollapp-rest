package ru.dsemenko.pollrest.web.services;

import org.springframework.stereotype.Service;
import ru.dsemenko.pollrest.web.repositories.RoleRepository;
import ru.dsemenko.pollrest.web.security.models.Role;
import ru.dsemenko.pollrest.web.services.interfaces.RoleService;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
