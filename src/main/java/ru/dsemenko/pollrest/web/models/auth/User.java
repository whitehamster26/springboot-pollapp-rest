package ru.dsemenko.pollrest.web.models.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dsemenko.pollrest.web.security.models.Role;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true, length = 30)
    private String username;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    @Column(nullable = false)
    @JsonIgnore
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Role> roles;
}
