package com.alvaro.login_demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

//conectar con la base de datos
public interface UserRepository extends JpaRepository<User, Long> {
    //buscar usuario por email
    Optional<User> findByEmail(String email);
}