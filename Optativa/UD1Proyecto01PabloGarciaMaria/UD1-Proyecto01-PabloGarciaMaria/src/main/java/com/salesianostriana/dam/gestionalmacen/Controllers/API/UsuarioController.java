package com.salesianostriana.dam.gestionalmacen.Controllers.API;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.NuevoUsuario_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Services.API.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> newUsuario(@RequestBody NuevoUsuario_UsuarioDTO usuario){
        return usuarioService.newUsuario(usuario);
    }




}

