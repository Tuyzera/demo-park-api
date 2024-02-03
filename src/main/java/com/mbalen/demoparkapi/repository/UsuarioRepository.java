package com.mbalen.demoparkapi.repository;

import com.mbalen.demoparkapi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsername(String username);

    List<Usuario> findByRole(Usuario.Role role);
}