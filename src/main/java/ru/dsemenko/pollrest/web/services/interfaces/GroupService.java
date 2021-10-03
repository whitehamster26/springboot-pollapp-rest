package ru.dsemenko.pollrest.web.services.interfaces;

import ru.dsemenko.pollrest.web.models.Group;
import ru.dsemenko.pollrest.web.models.auth.User;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    List<Group> getGroupsByUser(User user);
    Group getById(Long id);
    void save(Group group);
    void delete(Long id);
}
