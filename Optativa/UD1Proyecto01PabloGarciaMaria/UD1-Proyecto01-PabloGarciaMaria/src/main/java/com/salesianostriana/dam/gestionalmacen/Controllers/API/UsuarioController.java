package com.salesianostriana.dam.gestionalmacen.Controllers.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.ListarUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevoUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Services.API.UsuarioService;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    
    // ✅ C - Obtener plantilla v                                                                                                                  acía
    @GetMapping("/nuevo")
    public ResponseEntity<ApiResponse<NuevoUsuario_UsuarioDTO>> obtenerPlantillaUsuario() {
        log.info("Obteniendo plantilla de usuario");
        return usuarioService.obtenerPlantillaUsuario();
    }

    // ✅ C - Crear usuario
    @PostMapping
    public ResponseEntity<ApiResponse<ListarUsuario_UsuarioDTO>> crearUsuario(
            @RequestBody NuevoUsuario_UsuarioDTO usuario) {
        log.info("Solicitud de creación de usuario: {}", usuario.getUsername());
        return usuarioService.crearUsuario(usuario);
    }

    // ✅ R - Listar usuarios
    @GetMapping
    public ResponseEntity<ApiResponse<List<ListarUsuario_UsuarioDTO>>> obtenerUsuarios() {
        log.info("Listando todos los usuarios");
        return usuarioService.obtenerUsuarios();
    }

    // ✅ U - Actualizar usuario
    @PutMapping
    public ResponseEntity<ApiResponse<ListarUsuario_UsuarioDTO>> actualizarUsuario(
            @RequestBody ListarUsuario_UsuarioDTO usuarioDTO) {
        log.info("Actualizando usuario con id: {}", usuarioDTO.getId());
        return usuarioService.actualizarUsuario(usuarioDTO);
    }

    // ✅ D - Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ListarUsuario_UsuarioDTO>> eliminarUsuario(
            @PathVariable long id) {
        log.info("Eliminando usuario con id: {}", id);
        return usuarioService.eliminarUsuario(id);
    }


}

