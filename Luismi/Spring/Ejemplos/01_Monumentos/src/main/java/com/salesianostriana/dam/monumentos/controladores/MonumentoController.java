package com.salesianostriana.dam.monumentos.controladores;

import com.salesianostriana.dam.monumentos.modelos.CrearMonumentoCmd;
import com.salesianostriana.dam.monumentos.modelos.Monumento;
import com.salesianostriana.dam.monumentos.modelos.MonumentoResponse;
import com.salesianostriana.dam.monumentos.servicios.MonumentoServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento/")
@RequiredArgsConstructor
@Tag(description = "Controlador de monumentos", name = "Monumento Controller")
public class MonumentoController {

    private final MonumentoServicio servicio;

    @GetMapping
    @Operation(summary = "Obtiene todos los monumentos")
    @ApiResponse(
            responseCode = "200",
            description = "Lista de monumentos obtenida correcamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MonumentoResponse.class),
                    examples = @ExampleObject(
                            value = """
                                    [
                                      {
                                        "id": 1,
                                        "isoCode": "ES",
                                        "pais": "España",
                                        "localizacion": "Granada, Andalucía",
                                        "nombre": "La Alhambra",
                                        "descripcion": "Conjunto de palacios y fortalezas en Granada, España.",
                                        "url": "https://es.wikipedia.org/wiki/Alhambra"
                                      }
                                    ]
                                    """
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Lista de monumentos no encontrada",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation =  ProblemDetail.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "type": "http://dam.salesianos-triana.com/monumento-not-found",
                                              "title": "Monumento no encontrado",
                                              "status": 404,
                                              "detail": "No hay monumentos registrados",
                                              "instance": "/monumento/"
                                            }
                                            """
                            )
                    }
    )
    )
    public List<MonumentoResponse> getAll(){
        return servicio.getAll()
                .stream()
                .map(MonumentoResponse::of)
                //.map(MonumentoResponse::of)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un monumento por su ID")
    @ApiResponse(
            responseCode = "200",
            description = "Monumento encontrado",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MonumentoResponse.class)
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Monumento no encontrado",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProblemDetail.class),
                    examples = {
                        @ExampleObject(value = """
                                {
                                  "type": "http://dam.salesianos-triana.com/monumento-not-found",
                                  "title": "Monumento no encontrado",
                                  "status": 404,
                                  "detail": "No se ha encontrado el monumento con id 1",
                                  "instance": "/monumento/1"
                                }
                                """)
    }
            )
                    )
    public ResponseEntity<MonumentoResponse> getById(
            @Parameter(description = "ID del monumento a obtener", required = true, example = "1")
            @PathVariable Long id
    ){
        /*return ResponseEntity.of(
                servicio.getById(id)
                        .map(MonumentoResponse::of)
        );*/
        return ResponseEntity.ok(
                MonumentoResponse.of(servicio.getById(id)));
    }


    @PostMapping
    @Operation(summary = "Crea un nuevo monumento")
    @ApiResponse(
            responseCode = "201",
            description = "Monumento creado correctamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MonumentoResponse.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "id": 0,
                                              "isoCode": "es",
                                              "pais": "España",
                                              "localizacion": "Granada, Andalucía",
                                              "nombre": "La Alhambra",
                                              "descripcion": "Conjunto de palacios y fortalezas en Granada, España.",
                                              "url": "https://es.wikipedia.org/wiki/Alhambra"
                                            }
                                            """
                            )
                    }
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Fallo al crear el monumento",
            content = @Content(
                    mediaType = "aplication/json",
                    schema = @Schema(implementation = ProblemDetail.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "type": "http://dam.salesianos-triana.com/monumento-not-found",
                                              "title": "Monumento no encontrado",
                                              "status": 404,
                                              "detail": "No se ha encontrado el monumento con id 1",
                                              "instance": "/monumento/1"
                                            }
                                            """
                            )
                    }
            )
    )
    public ResponseEntity<MonumentoResponse> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objeto JSON que representa el monumento a crear",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = CrearMonumentoCmd.class),
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                    {
                                                      "isoCode": "es",
                                                      "pais": "España",
                                                      "localizacion": "Granada, Andalucía",
                                                      "nombre": "La Alhambra",
                                                      "descripcion": "Conjunto de palacios y fortalezas en Granada, España.",
                                                      "url": "https://es.wikipedia.org/wiki/Alhambra"
                                                    }
                                                    """
                                    )
                            }
                    )

            )
            @RequestBody CrearMonumentoCmd cmd
    ) {
        Monumento nuevo = servicio.save(cmd);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MonumentoResponse.of(nuevo));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza un monumento por su ID")
    @ApiResponse(
            responseCode = "200",
            description = "Monumento actualizado correctamente",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MonumentoResponse.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "id": 1,
                                              "isoCode": "es",
                                              "pais": "Espania",
                                              "localizacion": "Granada, Andalucía",
                                              "nombre": "La Alhambra",
                                              "descripcion": "Conjunto de palacios y fortalezas en Granada, España.",
                                              "url": "Conjunto de palacios y fortalezas en Granada, España."
                                            }
                                            """
                            )
                    }
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Monumento no encontrado para actualizar",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProblemDetail.class),
                    examples = {
                            @ExampleObject(
                                    value = """
                                            {
                                              "type": "http://dam.salesianos-triana.com/monumento-not-found",
                                              "title": "Monumento no encontrado",
                                              "status": 404,
                                              "detail": "No se ha encontrado el monumento con id 11",
                                              "instance": "/monumento/11"
                                            }
                                            """
                            )
                    }
            )
    )
    public ResponseEntity<MonumentoResponse> edit(
            @Parameter(description = "ID del monumento a actualizar", required = true, example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objeto JSON que representa el monumento a actualizar",
                    required = true,
                    content = @Content(
                            schema = @Schema(implementation = CrearMonumentoCmd.class),
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                    {
                                                      "isoCode": "ES",
                                                      "pais": "España",
                                                      "localizacion": "Granada, Andalucía",
                                                      "nombre": "La Alhambra",
                                                      "descripcion": "Conjunto de palacios y fortalezas en Granada, España.",
                                                      "url": "https://es.wikipedia.org/wiki/Alhambra"
                                                    }
                                                    """
                                    )
                            }
                    )

            )
            @RequestBody CrearMonumentoCmd cmd) {

        return ResponseEntity.ok(
                MonumentoResponse.of(
                    servicio.edit(cmd, id)
        ));

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un monumento por su ID")
    @ApiResponse(
        responseCode = "204",
        description = "Monumento eliminado correctamente",
            content = @Content(
                    mediaType = "application/json",
                    examples = {
                            @ExampleObject(
                                    value = """
                                             connection: keep-alive\s
                                             date: Wed,19 Nov 2025 12:37:48 GMT\s
                                             keep-alive: timeout=60\s
                                            """
                            )
                    }
            )
    )
    public ResponseEntity<?> delete(
            @Parameter(description = "ID del monumento a eliminar", required = true, example = "1")
            @PathVariable Long id
    ) {
        servicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
