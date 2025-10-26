package com.salesianostriana.dam.gestionalmacen.Services.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevoUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    public ResponseEntity<String> newUsuario(NuevoUsuario_UsuarioDTO usuario) {
        try {
            Usuario newUser = usuario.UsuarioDTOtoUsuario();
            repository.save(newUser);
            log.info("Usuario creado: " + newUser.getUsername());
            return ResponseEntity.ok("Usuario creado correctamente");
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(500).body("Error al crear el usuario: " + e.getMessage());
        }

    }
}
