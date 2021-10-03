package ru.dsemenko.pollrest.web.services;

import org.springframework.stereotype.Service;
import ru.dsemenko.pollrest.web.models.Group;
import ru.dsemenko.pollrest.web.models.auth.User;
import ru.dsemenko.pollrest.web.repositories.GroupRepository;
import ru.dsemenko.pollrest.web.services.interfaces.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;

    public GroupServiceImpl(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findGroupsByIsHiddenFalse();
    }

    @Override
    public List<Group> getGroupsByUser(User user) {
        return groupRepository.findGroupsByMembersContains(user);
    }

    @Override
    public Group getById(Long id) {
        return groupRepository.getById(id);
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void delete(Long id) {
        groupRepository.deleteById(id);
    }
}
