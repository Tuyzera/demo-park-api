package com.mbalen.demoparkapi.controller;

import com.mbalen.demoparkapi.entity.Usuario;
import com.mbalen.demoparkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios") //Url de acesso
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        Usuario user =  usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable long id){
        Usuario user = usuarioService.buscarPorID(id);
        return ResponseEntity.ok(user);

    }

}
