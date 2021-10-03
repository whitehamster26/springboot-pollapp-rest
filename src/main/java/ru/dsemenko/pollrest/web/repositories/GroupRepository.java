package ru.dsemenko.pollrest.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dsemenko.pollrest.web.models.Group;
import ru.dsemenko.pollrest.web.models.auth.User;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    List<Group> findGroupsByMembersContains(User member);
    List<Group> findGroupsByIsHiddenFalse();
}
