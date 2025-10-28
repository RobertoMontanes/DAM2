package com.salesianostriana.dam.gestionalmacen.Services.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.ListarSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.ListarUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevaSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevoUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.SubscripcionRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscripcionService extends BaseServiceImpl<Subscripcion, Long, SubscripcionRepository> {

    private static final Logger log = LoggerFactory.getLogger(SubscripcionService.class);

    public ResponseEntity<ApiResponse<NuevaSubscripcion_SubscripcionDTO>> obtenerPlantillaSubscripcion() { // C
        NuevaSubscripcion_SubscripcionDTO plantilla = new NuevaSubscripcion_SubscripcionDTO();
        return ResponseEntity.ok(ApiResponse.success(plantilla));
    }

    public ResponseEntity<ApiResponse<ListarSubscripcion_SubscripcionDTO>> crearSubscripcion(NuevaSubscripcion_SubscripcionDTO s) { // C
        Subscripcion newSub = s.fromDTO();
        repository.save(newSub);
        log.info("Subscripción creado: {}", newSub.getNombre());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(ListarSubscripcion_SubscripcionDTO.toDTO(newSub)));
    }

    public ResponseEntity<ApiResponse<List<ListarSubscripcion_SubscripcionDTO>>> obtenerSubscripciones() { // R
        List<ListarSubscripcion_SubscripcionDTO> subscripciones = repository.findAll().stream()
                .map(ListarSubscripcion_SubscripcionDTO::toDTO)
                .toList();

        return ResponseEntity.ok(ApiResponse.success(subscripciones));
    }



}
