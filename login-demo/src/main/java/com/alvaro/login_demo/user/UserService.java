package com.alvaro.login_demo.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;

    // Spring inyecta el repositorio
    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    // Registro
    public User register(String email, String rawPassword, String nombre) {
        if (repo.findByEmail(email).isPresent()) {
            throw new IllegalStateException("El email ya existe");
        }

        User u = new User();
        u.setEmail(email);
        u.setPasswordHash(rawPassword); // ⚠️ más adelante aquí deberíamos usar un hash real
        u.setNombre(nombre);

        return repo.save(u);
    }

    // Login
    public boolean login(String email, String rawPassword) {
        User user = repo.findByEmail(email).orElse(null);
        if (user == null) {
            return false;
        }
        return user.getPasswordHash().equals(rawPassword);
    }
}
