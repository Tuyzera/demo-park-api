package com.mbalen.demoparkapi.service;

import com.mbalen.demoparkapi.entity.Usuario;
import com.mbalen.demoparkapi.exception.UsernameDoesntExist;
import com.mbalen.demoparkapi.exception.UsernameUniqueValueException;
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
        try {
            return usuarioRepository.save(usuario);
        } catch (org.springframework.dao.DataIntegrityViolationException error){
            throw new UsernameUniqueValueException(String.format("Username '%s' já cadastrado", usuario.getUsername()));
        }

    }
    @Transactional(readOnly = true) //Exclusivo para uma consulta ao banco de dados
    public Usuario buscarPorID(Long id) {
        try {
            return usuarioRepository.findById(id).get();
        } catch (java.lang.RuntimeException error){
            throw new UsernameDoesntExist(String.format("Usuário não existente!"));
        }
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
    public Usuario atualizarUserPorId(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if(!novaSenha.equals(confirmaSenha)){
            throw new RuntimeException("Nova senha não confere com a confirmação de senha");
        }
        Usuario user = buscarPorID(id);
        if(!user.getPassword().equals(senhaAtual)){
            throw new RuntimeException("Senha não confere com a senha atual!");
        }
        user.setPassword(novaSenha);
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
