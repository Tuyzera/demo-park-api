package com.mbalen.demoparkapi.controller;

import com.mbalen.demoparkapi.controller.dto.UsuarioCreateDTO;
import com.mbalen.demoparkapi.controller.dto.UsuarioResponseDTO;
import com.mbalen.demoparkapi.controller.dto.UsuarioSenhaDto;
import com.mbalen.demoparkapi.controller.dto.mapper.UsuarioMapper;
import com.mbalen.demoparkapi.entity.Usuario;
import com.mbalen.demoparkapi.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios") //Url de acesso
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@Valid @RequestBody UsuarioCreateDTO createDTO){
        Usuario user =  usuarioService.salvar(UsuarioMapper.toUsuario(createDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getUserById(@PathVariable long id){
        Usuario user = usuarioService.buscarPorID(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUserById(@PathVariable Long id){
        Usuario user = usuarioService.deleteUserPorID(id);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UsuarioResponseDTO>> getAllUsers(){
        List<Usuario> user = usuarioService.getAllUsers();
        return ResponseEntity.ok(UsuarioMapper.toListDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchUserById(@Valid @PathVariable Long id, @RequestBody UsuarioSenhaDto userParam){
        Usuario user = usuarioService.atualizarUserPorId(id, userParam.getSenhaAtual(), userParam.getNovaSenha(), userParam.getConfirmaSenha());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/name/{username}")
    public ResponseEntity<Usuario> GetUserByName(@PathVariable String username){
        Usuario user = usuarioService.buscarPorNome(username);
        return ResponseEntity.ok(user);
    }


    @ApiResponse(
            responseCode = "200",
            description = "Get all user by Role",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Usuario.class)))
    @Operation(summary = "Get all user by Role", description = "Get all user by Role")
    @GetMapping("/roles/{role}")
    public ResponseEntity<List<Usuario>> getUserRoles(@PathVariable String role){
        List<Usuario> users = usuarioService.getUserByRole(role);
        return ResponseEntity.ok(users);
    }







}

