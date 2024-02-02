package com.mbalen.demoparkapi.service;

import com.mbalen.demoparkapi.entity.Usuario;
import com.mbalen.demoparkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


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
}
