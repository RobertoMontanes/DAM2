package com.salesianostriana.dam.gestionalmacen.Services.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.ListarUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevoUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    public ResponseEntity<ApiResponse<NuevoUsuario_UsuarioDTO>> obtenerPlantillaUsuario() { // C
        NuevoUsuario_UsuarioDTO plantilla = new NuevoUsuario_UsuarioDTO();
        return ResponseEntity.ok(ApiResponse.success(plantilla));

    }
    
	public ResponseEntity<ApiResponse<ListarUsuario_UsuarioDTO>> crearUsuario(NuevoUsuario_UsuarioDTO usuario) { // C
        Usuario newUser = usuario.UsuarioDTOtoUsuario();
        repository.save(newUser);
        log.info("Usuario creado: " + newUser.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ListarUsuario_UsuarioDTO.UsuarioToUsuarioDTO(newUser)));
    }
    
    public ResponseEntity<ApiResponse<List<ListarUsuario_UsuarioDTO>>> obtenerUsuarios() { // R
        List<ListarUsuario_UsuarioDTO> usuarios = repository.findAll().stream()
                .map(ListarUsuario_UsuarioDTO::UsuarioToUsuarioDTO)
                .toList();

        return ResponseEntity.ok(ApiResponse.success(usuarios));
    }
    
    public ResponseEntity<ApiResponse<ListarUsuario_UsuarioDTO>> actualizarUsuario(ListarUsuario_UsuarioDTO usuarioDTO) { // U
    	
    	Usuario u;
    	Optional<Usuario> uOrOpt = repository.findById(usuarioDTO.getId());
    	
    	if (uOrOpt.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Usuario no encontrado"));
    	}
    	u = repository.save(uOrOpt.get().modify(usuarioDTO.UsuarioDTOtoUsuario()));
  
    	return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(ListarUsuario_UsuarioDTO.UsuarioToUsuarioDTO(u)));
    }

    public ResponseEntity<ApiResponse<ListarUsuario_UsuarioDTO>> eliminarUsuario(long id) { // D
        return repository.findById(id)
                .map(usuario -> {
                    repository.delete(usuario);
                    log.info("Usuario eliminado: {}", usuario.getUsername());
                    ListarUsuario_UsuarioDTO dto = ListarUsuario_UsuarioDTO.UsuarioToUsuarioDTO(usuario);
                    return ResponseEntity.ok(ApiResponse.success(dto));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("Usuario no encontrado")));
    }

}
