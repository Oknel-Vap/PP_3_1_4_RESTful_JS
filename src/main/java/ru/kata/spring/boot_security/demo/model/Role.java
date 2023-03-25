package ru.kata.spring.boot_security.demo.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String role;

    public Role() {
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }

//    @ManyToMany(mappedBy = "roles")
//            private Collection<User> users;


    @Override
    public String getAuthority() {
        return role;
    }


    @Override
    public String toString() {
        return role.replace("ROLE_", "");
    }
}
