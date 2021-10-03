package ru.dsemenko.pollrest.web.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import ru.dsemenko.pollrest.web.models.Group;
import ru.dsemenko.pollrest.web.models.auth.User;
import ru.dsemenko.pollrest.web.security.models.Role;
import ru.dsemenko.pollrest.web.services.interfaces.GroupService;
import ru.dsemenko.pollrest.web.services.interfaces.RoleService;
import ru.dsemenko.pollrest.web.services.interfaces.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class AppDataInit {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppDataInit.class);
    private UserService userService;
    private RoleService roleService;
    private GroupService groupService;

    public AppDataInit(UserService userService, RoleService roleService, GroupService groupService) {
        this.userService = userService;
        this.roleService = roleService;
        this.groupService = groupService;
        LOGGER.debug("UserService bean - {}", userService);
        LOGGER.debug("RoleService bean - {}", roleService);
        createRoles();
        LOGGER.debug("Roles created");
        createSuperUser();
        LOGGER.debug("SuperUser created");
        createGroup();
        LOGGER.debug("Groups created");
    }

    private void createRoles() {
        Role roleUser = new Role();
        Role roleAdmin = new Role();

        roleUser.setName("USER");
        roleAdmin.setName("ADMIN");

        roleService.save(roleUser);
        roleService.save(roleAdmin);
    }

    private void createSuperUser() {
        User user = new User();
        List<Role> userRoles = new ArrayList<>(Arrays.asList(roleService.getByName("USER"),
                roleService.getByName("ADMIN")));
        user.setUsername("admin");
        user.setEmail("admin@admin.ru");
        user.setPassword("admin1234");
        user.setRoles(userRoles);
        userService.save(user);
    }

    private void createGroup() {
        Group group = new Group();
        Group group1 = new Group();
        Group hiddenGroup = new Group();
        group.setName("First group");
        group1.setName("Second group");
        hiddenGroup.setName("I'm hidden lol");
        group.setIsHidden(false);
        group1.setIsHidden(false);
        hiddenGroup.setIsHidden(true);
        hiddenGroup.addUser(userService.getByEmail("admin@admin.ru"));
        group.addUser(userService.getByEmail("admin@admin.ru"));
        groupService.save(group);
        groupService.save(group1);
        groupService.save(hiddenGroup);
    }
}
