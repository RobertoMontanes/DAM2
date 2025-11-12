package com.salesianostriana.dam.gestionsuscripciones.Controllers.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.DTO.Usuario.Formulario_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Services.Usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public String listar(Model model) {
        return service.listar(model);
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        return service.nuevo(model,null);
    }

    @PostMapping
    public String crear(@ModelAttribute Formulario_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes, Model model) {
        return service.crear(usuarioDTO, redirectAttributes, model);
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return service.editar(id, model, redirectAttributes);
    }

    @PutMapping()
    public String actualizar(@ModelAttribute Formulario_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes, Model model) {
        return service.actualizar(usuarioDTO, redirectAttributes, model);
    }

    @GetMapping("/estado/{id}")
    public String cambiarEstado(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        return service.cambiarEstado(id, redirectAttributes);
    }

    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        return service.verDetalle(id, model, redirectAttributes);
    }

}

