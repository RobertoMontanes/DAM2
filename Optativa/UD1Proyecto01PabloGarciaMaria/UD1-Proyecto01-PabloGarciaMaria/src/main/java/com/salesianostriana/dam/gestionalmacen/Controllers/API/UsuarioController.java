package com.salesianostriana.dam.gestionalmacen.Controllers.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.ListarUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevoUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Services.API.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/test")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> crearUsuario(@RequestBody NuevoUsuario_UsuarioDTO usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @GetMapping("/new")
    public ResponseEntity<NuevoUsuario_UsuarioDTO> obtenerPlantillaUsuario(){
        return usuarioService.obtenerPlantillaUsuario();
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<ListarUsuario_UsuarioDTO>> listarUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable long id) {
        return usuarioService.eliminarUsuario(id);
    }


}

