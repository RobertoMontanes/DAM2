package com.salesianostriana.dam.gestionalmacen.Services.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.ListarUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevoUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    public ResponseEntity<String> crearUsuario(NuevoUsuario_UsuarioDTO usuario) {
        Usuario newUser = usuario.UsuarioDTOtoUsuario();
        repository.save(newUser);
        log.info("Usuario creado: " + newUser.getUsername());
        return ResponseEntity.ok("Usuario creado correctamente");
    }

    public ResponseEntity<NuevoUsuario_UsuarioDTO> obtenerPlantillaUsuario() {
        NuevoUsuario_UsuarioDTO usuarioDTO = new NuevoUsuario_UsuarioDTO();
        return ResponseEntity.status(200).body(usuarioDTO);
    }

    public ResponseEntity<List<ListarUsuario_UsuarioDTO>> obtenerUsuarios() {
        List<ListarUsuario_UsuarioDTO> usuariosDTO = repository.findAll().stream().map(ListarUsuario_UsuarioDTO::UsuarioToUsuarioDTO).toList();
        return ResponseEntity.status(200).body(usuariosDTO);
    }

    public ResponseEntity<String> eliminarUsuario(long id) {
        Optional<Usuario> usuario = findById(id);

        if (usuario.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(usuario.get());
        return ResponseEntity.ok("Usuario " + usuario.get().getUsername() + " eliminado.");

    }
}
