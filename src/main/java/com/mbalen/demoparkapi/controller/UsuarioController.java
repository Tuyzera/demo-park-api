package com.mbalen.demoparkapi.controller;

import com.mbalen.demoparkapi.entity.Usuario;
import com.mbalen.demoparkapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUserById(@PathVariable Long id){
        Usuario user = usuarioService.deleteUserPorID(id);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> user = usuarioService.getAllUsers();
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> patchUserById(@PathVariable Long id, @RequestBody Usuario userParam){
        Usuario user = usuarioService.atualizarUserPorId(id, userParam.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping("/name/{username}")
    public ResponseEntity<Usuario> GetUserByName(@PathVariable String username){
        Usuario user = usuarioService.buscarPorNome(username);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/roles/{role}")
    public ResponseEntity<List<Usuario>> getUserRoles(@PathVariable String role){
        List<Usuario> users = usuarioService.getUserByRole(role);
        return ResponseEntity.ok(users);
    }


}

