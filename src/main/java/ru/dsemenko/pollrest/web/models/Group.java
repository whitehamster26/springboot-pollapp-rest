package ru.dsemenko.pollrest.web.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dsemenko.pollrest.web.models.auth.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
@NoArgsConstructor
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany
    @JsonIgnore
    private List<User> members;
    @JsonIgnore
    private Boolean isHidden;

    public void addUser(User user) {
        if (members == null) {
            members = new ArrayList<>();
        }
        if (members.contains(user)) {
            throw new IllegalArgumentException("Пользователь уже состоит в группе");
        } else {
            members.add(user);
        }
    }
}
