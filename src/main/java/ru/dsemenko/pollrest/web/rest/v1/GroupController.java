package ru.dsemenko.pollrest.web.rest.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dsemenko.pollrest.web.models.Group;
import ru.dsemenko.pollrest.web.models.auth.User;
import ru.dsemenko.pollrest.web.services.interfaces.GroupService;
import ru.dsemenko.pollrest.web.services.interfaces.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups/")
public class GroupController {
    private GroupService groupService;
    private UserService userService;

    public GroupController(GroupService groupService, UserService userService) {
        this.groupService = groupService;
        this.userService = userService;
    }

    @GetMapping("list")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("my")
    public List<Group> getPrincipalGroups(Principal principal) {
        User principalUser = userService.getByUsername(principal.getName());
        return groupService.getGroupsByUser(principalUser);
    }
}
