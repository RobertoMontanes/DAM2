package com.salesianostriana.dam.gestionsuscripciones.Controllers.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.DTO.Usuario.Listar_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.DTO.Usuario.Nuevo_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Services.Usuario.UsuarioService;
import lombok.RequiredArgsConstructor;import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public String listarUsuarios(Model model) {
        return usuarioService.listar(model);
    }

    @GetMapping("/{id}")
    public String ver(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        return usuarioService.ver(model, id, redirectAttributes);
    }


}

