package com.mbalen.demoparkapi.service;

import com.mbalen.demoparkapi.entity.Usuario;
import com.mbalen.demoparkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor //Criar um metodo construtor com a variavel usuario repository
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    @Transactional(readOnly = true) //Exclusivo para uma consulta ao banco de dados
    public Usuario buscarPorID(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario não encontrado!")
        );
    }

    @Transactional
    public Usuario deleteUserPorID(Long id) {
        Usuario user = buscarPorID(id);
        if(user != null){
            usuarioRepository.deleteById(id);
        }
        return user;
    }

    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }
    @Transactional
    public Usuario atualizarUserPorId(Long id, String fieldUpdate) {
        Usuario user = buscarPorID(id);
        user.setPassword(fieldUpdate);
        return user;
    }
    @Transactional(readOnly = true)
    public Usuario buscarPorNome(String username) {
        return this.usuarioRepository.findByUsername(username);
    }

    public List<Usuario> getUserByRole(String role) {
        Usuario.Role roles = Usuario.Role.valueOf(role.toUpperCase());
        return this.usuarioRepository.findByRole(roles);
    }
}
