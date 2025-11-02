package com.salesianostriana.dam.gestionalmacen.Services.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.ListarUsuario_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.NuevoUsuario_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class  UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    public ResponseEntity<ApiResponse<NuevoUsuario_DTO>> obtenerPlantillaUsuario() { // C
        NuevoUsuario_DTO plantilla = new NuevoUsuario_DTO();
        return ResponseEntity.ok(ApiResponse.success(plantilla));

    }
    
	public ResponseEntity<ApiResponse<ListarUsuario_DTO>> crearUsuario(NuevoUsuario_DTO usuario) { // C
        Usuario newUser = usuario.UsuarioDTOtoUsuario();
        repository.save(newUser);
        log.info("Usuario creado: {}", newUser.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ListarUsuario_DTO.UsuarioToUsuarioDTO(newUser)));
    }
    
    public ResponseEntity<ApiResponse<List<ListarUsuario_DTO>>> obtenerUsuarios() { // R

        List<ListarUsuario_DTO> usuarios = repository.findAll().stream()
                .map(ListarUsuario_DTO::UsuarioToUsuarioDTO)
                .toList();

        return ResponseEntity.ok(ApiResponse.success(usuarios));
    }
    
    public ResponseEntity<ApiResponse<ListarUsuario_DTO>> actualizarUsuario(ListarUsuario_DTO usuarioDTO) { // U
        System.out.println("UPDATE SERVICE LLEGA ID: " + usuarioDTO.getId());
    	Usuario u;
    	Optional<Usuario> uOrOpt = repository.findById(usuarioDTO.getId());
    	
    	if (uOrOpt.isEmpty()) {
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Usuario no encontrado"));
    	}
    	u = repository.save(uOrOpt.get().modify(usuarioDTO.UsuarioDTOtoUsuario()));
  
    	return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(ListarUsuario_DTO.UsuarioToUsuarioDTO(u)));
    }

    public ResponseEntity<ApiResponse<ListarUsuario_DTO>> eliminarUsuario(long id) { // D
        return repository.findById(id)
                .map(usuario -> {
                    repository.delete(usuario);
                    log.info("Usuario eliminado: {}", usuario.getUsername());
                    ListarUsuario_DTO dto = ListarUsuario_DTO.UsuarioToUsuarioDTO(usuario);
                    return ResponseEntity.ok(ApiResponse.success(dto));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("Usuario no encontrado")));
    }

}
