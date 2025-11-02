package com.salesianostriana.dam.gestionalmacen.Controllers.API.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.ListarUsuario_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.NuevoUsuario_DTO;
import com.salesianostriana.dam.gestionalmacen.Services.API.Usuario.UsuarioService;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
    
    // ✅ C - Obtener plantilla vacía
    @GetMapping("/nuevo")
    public ResponseEntity<ApiResponse<NuevoUsuario_DTO>> obtenerPlantillaUsuario() {
        log.info("Obteniendo plantilla de usuario");
        return usuarioService.obtenerPlantillaUsuario();
    }

    // ✅ C - Crear usuario
    @PostMapping
    public ResponseEntity<ApiResponse<ListarUsuario_DTO>> crearUsuario(
            @RequestBody NuevoUsuario_DTO usuario) {
        log.info("Solicitud de creación de usuario: {}", usuario.getUsername());
        return usuarioService.crearUsuario(usuario);
    }

    // ✅ R - Listar usuarios
    @GetMapping
    public ResponseEntity<ApiResponse<List<ListarUsuario_DTO>>> obtenerUsuarios() {
        log.info("Listando todos los usuarios");
        return usuarioService.obtenerUsuarios();
    }

    // ✅ U - Actualizar usuario
    @PutMapping
    public ResponseEntity<ApiResponse<ListarUsuario_DTO>> actualizarUsuario(
            @RequestBody ListarUsuario_DTO usuarioDTO) {
        log.info("Actualizando usuario con id: {}", usuarioDTO.getId());
        return usuarioService.actualizarUsuario(usuarioDTO);
    }

    // ✅ D - Eliminar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<ListarUsuario_DTO>> eliminarUsuario(
            @PathVariable long id) {
        log.info("Eliminando usuario con id: {}", id);
        return usuarioService.eliminarUsuario(id);
    }


}

