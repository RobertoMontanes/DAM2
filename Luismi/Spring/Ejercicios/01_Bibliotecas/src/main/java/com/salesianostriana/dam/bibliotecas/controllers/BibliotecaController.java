package com.salesianostriana.dam.bibliotecas.controllers;

import com.salesianostriana.dam.bibliotecas.errors.NotEnoughElementsException;
import com.salesianostriana.dam.bibliotecas.models.dtos.BibliotecaDetailsResponse;
import com.salesianostriana.dam.bibliotecas.models.dtos.CreateBibliotecaRequest;
import com.salesianostriana.dam.bibliotecas.models.dtos.EditBibliotecaRequest;
import com.salesianostriana.dam.bibliotecas.models.dtos.ListBibliotecaResponse;
import com.salesianostriana.dam.bibliotecas.services.BibliotecaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
@Tag(description = "Controlador de biblioteca", name = "Biblioteca Controller")
public class BibliotecaController {
//    In -> Request
//    Out -> Response
    
    private final BibliotecaService service;

    @GetMapping()
    @Operation(summary = "Obtiene la lista de todas las bibliotecas")
    @ApiResponse(
            responseCode = "200",
            description = "Listado de bibliotecas obtenido correctamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ListBibliotecaResponse.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            [
                                              {
                                                "id": 1,
                                                "city_name": "Sevilla",
                                                "library_name": "Bibliteca0",
                                                "oficial_page_url": "https://biblioteca0-sev.es"
                                              }
                                            ]
                                            """
                            )
                    }
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "No se ha encontrado ninguna biblioteca en el listado.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProblemDetail.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "type": "http://dam.salesianos-triana.com/biblioteca-not-found",
                                              "title": "null no encontrado/s",
                                              "status": 404,
                                              "detail": "No se han encontrado registros de bibliotecas.",
                                              "instance": "/library"
                                            }
                                            """
                            )
                    }
            )
    )
    public ResponseEntity<List<ListBibliotecaResponse>> listarBibliotecas() {
        return ResponseEntity.ok(service.listarBibliotecas()
                .stream()
                .map(ListBibliotecaResponse::of)
                .toList());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene los detalles de la biblioteca especificada.")
    @ApiResponse(
            responseCode = "404",
            description = "No se han encontrado los detalles de la biblioteca especificada.",
            content = @Content(
                    mediaType = "application/JSON",
                    schema = @Schema(implementation = ProblemDetail.class),
                    examples = {@ExampleObject(
                            value = """
                                    {
                                      "type": "http://dam.salesianos-triana.com/biblioteca-not-found",
                                      "title": "Libreria con ID: 1 no encontrada.",
                                      "status": 404,
                                      "instance": "/library/1"
                                    }
                                    """
                    )}
            )
    )
    @ApiResponse(
            responseCode = "200",
            description = "Detalles de biblioteca obtenidos.",
            content = @Content(
                    mediaType = "application/JSON",
                    schema = @Schema(implementation = BibliotecaDetailsResponse.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "id": 1,
                                              "city_name": "Sevilla",
                                              "library_name": "Bibliteca0",
                                              "foundation_year": "2020",
                                              "number_of_books": 10200,
                                              "general_description": "A lot of text here.",
                                              "oficial_page_url": "https://biblioteca0-sev.es"
                                            }
                                            """
                            )
                    }
            )
    )
    public ResponseEntity<BibliotecaDetailsResponse> detallesBibliotecas(
            @Parameter(description = "ID de la biblioteca objetivo", required = true, example = "1")
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(BibliotecaDetailsResponse.of(service.detallesBiblioteca(id)));
    }

    @PostMapping()
    @Operation(summary = "Crea una nueva biblioteca.")
    @ApiResponse(
            responseCode = "201",
            description = "Biblioteca creada correctamente.",
            content = @Content(
                    mediaType = "application/JSON",
                    schema = @Schema(implementation = BibliotecaDetailsResponse.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "id": 1,
                                              "city_name": "Sevilla",
                                              "library_name": "Bibliteca0",
                                              "foundation_year": "2020",
                                              "number_of_books": 10200,
                                              "general_description": "A lot of text here.",
                                              "oficial_page_url": "https://biblioteca0-sev.es"
                                            }
                                            """
                            )
                    }
            )
    )
    public ResponseEntity<BibliotecaDetailsResponse> crearBiblioteca(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objeto JSON que representa la biblioteca a crear.",
                    required = true,
                    content = @Content(
                            mediaType = "application/JSON",
                            schema = @Schema(implementation = CreateBibliotecaRequest.class),
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                    {
                                                    "city_name": "Sevilla",
                                                    "library_name": "Bibliteca0",
                                                    "foundation_year": 2020,
                                                    "number_of_books": 10200,
                                                    "general_description": "A lot of text here.",
                                                    "oficial_page_url": "https://biblioteca0-sev.es"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
            @RequestBody CreateBibliotecaRequest bibliotecaDTO
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(BibliotecaDetailsResponse.of(service.crearBiblioteca(bibliotecaDTO)));
    }

    @ApiResponse(
            responseCode = "404",
            description = "No se han encontrado la biblioteca especificada.",
            content = @Content(
                    mediaType = "application/JSON",
                    schema = @Schema(implementation = ProblemDetail.class),
                    examples = {@ExampleObject(
                            value = """
                                    {
                                      "type": "http://dam.salesianos-triana.com/biblioteca-not-found",
                                      "title": "Biblioteca con ID: 1 no encontrada.",
                                      "status": 404,
                                      "instance": "/library/1"
                                    }
                                    """
                    )}
            )
    )
    @ApiResponse(
            responseCode = "200",
            description = "Biblioteca actualizada correctamente.",
            content = @Content(
                    mediaType = "application/JSON",
                    schema = @Schema(implementation = BibliotecaDetailsResponse.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                                                                        {
                                              "id": 1,
                                              "city_name": "SevillaS",
                                              "library_name": "Bibliteca0",
                                              "foundation_year": "2020",
                                              "number_of_books": 10200,
                                              "general_description": "A lot of text here.",
                                              "oficial_page_url": "https://biblioteca0-sev.es"
                                            }
                                            """
                            )
                    }
            )
    )
    @PutMapping("/{id}")
    @Operation(summary = "Modificar una biblioteca existente.")
    public ResponseEntity<BibliotecaDetailsResponse> modificarBiblioteca(
            @Parameter(required = true, example = "1", description = "ID del monumento a editar.")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objeto DTO que contiene los datos de la biblioteca que se creara",
                    required = true,
                    content = @Content(
                            mediaType = "application/JSON",
                            schema = @Schema(implementation = EditBibliotecaRequest.class),
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                    {
                                                    "city_name": "SevillaS",
                                                    "library_name": "Bibliteca0",
                                                    "foundation_year": 2020,
                                                    "number_of_books": 10200,
                                                    "general_description": "A lot of text here.",
                                                    "oficial_page_url": "https://biblioteca0-sev.es"
                                                    }
                                                    """
                                    )
                            }
                    )
            )
            @RequestBody EditBibliotecaRequest bibliotecaDTO
    ) {
        return ResponseEntity.ok(BibliotecaDetailsResponse.of(service.modificarBiblioteca(id, bibliotecaDTO)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina una biblioteca")
    @ApiResponse(
            responseCode = "404",
            description = "No se han encontrado la biblioteca especificada.",
            content = @Content(
                    mediaType = "application/JSON",
                    schema = @Schema(implementation = ProblemDetail.class),
                    examples = {@ExampleObject(
                            value = """
                                    {
                                      "type": "http://dam.salesianos-triana.com/biblioteca-not-found",
                                      "title": "Libreria con ID: 1 no encontrada.",
                                      "status": 404,
                                      "instance": "/library/1"
                                    }
                                    """
                    )}
            )
    )
    @ApiResponse(
            responseCode = "204",
            description = "Biblioteca eliminada correctamente",
            content = @Content(
                    mediaType = "application/JSON",
                    schema = @Schema(implementation = String.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            Biblioteca eliminada correctamente.
                                            """
                            )
                    }
            )
    )
    public ResponseEntity<String>  eliminarBiblioteca(
            @Parameter(required = true, example = "1", description = "ID de la biblioteca que eliminaremos.")
            @PathVariable Long id
    ) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.eliminarBiblioteca(id));
    }


}
