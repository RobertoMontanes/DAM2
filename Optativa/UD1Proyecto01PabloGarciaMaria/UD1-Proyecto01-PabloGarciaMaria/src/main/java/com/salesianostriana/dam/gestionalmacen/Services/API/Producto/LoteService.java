package com.salesianostriana.dam.gestionalmacen.Services.API.Producto;

import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Lote.ListarLote_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Lote.NuevoLote_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.Accion;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Lote;
import com.salesianostriana.dam.gestionalmacen.Repositories.Producto.LoteRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import com.salesianostriana.dam.gestionalmacen.Utils.APIResponse.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class LoteService extends BaseServiceImpl<Lote,Long, LoteRepository> {

    public ResponseEntity<ApiResponse<NuevoLote_DTO>> obtenerPlantilla() {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(new NuevoLote_DTO()));
    }

    public ResponseEntity<ApiResponse<ListarLote_DTO>> crear(NuevoLote_DTO l) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(ListarLote_DTO.toDTO(repository.save(l.fromDTO()))));
    }

    public ResponseEntity<ApiResponse<List<ListarLote_DTO>>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(repository.findAll().stream().map(ListarLote_DTO::toDTO).toList()));
    }

    public ResponseEntity<ApiResponse<ListarLote_DTO>> actualizar(ListarLote_DTO l) {
        return repository.findById(l.getId()).map(value ->
                ResponseEntity.status(HttpStatus.CREATED).body(
                        ApiResponse.success(ListarLote_DTO.toDTO(
                                repository.save(
                                        value.modify(
                                                l.fromDTO()))))))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.error("Lote no encontrado")));
    }

    public ResponseEntity<ApiResponse<ListarLote_DTO>> eliminar(long id) {
        return repository.findById(id)
                .map(l -> {
                    repository.delete(l);
                    ListarLote_DTO dto = ListarLote_DTO.toDTO(l);
                    return ResponseEntity.ok(ApiResponse.success(dto));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error("Lote no encontrado")));
    }

    public ResponseEntity<ApiResponse<Map<Integer, String>>> obtenerAcctiones() {
        return ResponseEntity.ok(ApiResponse.success(Accion.getAcciones()));
    }
}
