package com.salesianostriana.dam.gestionalmacen.Services.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevaSubscripcion_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevoUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.SubscripcionRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;
import org.springframework.http.ResponseEntity;

public class SubscripcionService extends BaseServiceImpl<Subscripcion, Long, SubscripcionRepository> {

    public ResponseEntity<ApiResponse<NuevaSubscripcion_SubscripcionDTO>> obtenerPlantillaSubscripcion() { // C
        NuevaSubscripcion_SubscripcionDTO plantilla = new NuevaSubscripcion_SubscripcionDTO();
        return ResponseEntity.ok(ApiResponse.success(plantilla));
    }



}
