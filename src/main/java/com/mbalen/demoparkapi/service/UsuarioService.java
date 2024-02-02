package com.mbalen.demoparkapi.service;

import com.mbalen.demoparkapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor //Criar um metodo construtor com a variavel usuario repository
@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
}
