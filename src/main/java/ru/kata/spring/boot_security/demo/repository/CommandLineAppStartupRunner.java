package ru.kata.spring.boot_security.demo.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CommandLineAppStartupRunner {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @PostConstruct
    public void init() {
        Role role = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");
        roleRepository.save(role);
        roleRepository.save(role2);
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(role);
        User admin = new User();
        admin.setName("admin");
        admin.setLastName("adminov");
        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setRoles(adminRoles);
        userRepository.save(admin);
    }
}
