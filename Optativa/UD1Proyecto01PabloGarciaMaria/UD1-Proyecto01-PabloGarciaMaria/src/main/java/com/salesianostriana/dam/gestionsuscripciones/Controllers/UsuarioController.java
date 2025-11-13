package com.salesianostriana.dam.gestionsuscripciones.Controllers;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.Formulario_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {

    // Para mañana hay que empezar a trabajar con las suscripciones pero antes tenemos que terminar los planes
    // Falta editar y eliminar planes
    // Despues de eso nos quedaria hacer las suscripciones
    // Acuerdate que cuando creas una plataforma te pregunta si tienes una suscripcion activa y desde cuando.
        // SI el plazo es mayor a la frecuencia se creara una suscripcion por cada completo del periodo.
    // Los HTMLs despues de las suscripciones
    // Y por ultimo tocaria empezar a hacer cosas como mensajes y otras cosillas para actualizar al usuario sobre el estado de sus suscripciones.


    private final UsuarioService service;

//    @GetMapping
//    public String listar(Model model, HttpSession httpSession) {
//        return service.listar(model,httpSession);
//    }

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

//    @GetMapping("/{id}")
    @GetMapping()
    public String verDetalle(Model model, RedirectAttributes redirectAttributes, HttpSession httpSession) {
        return service.verDetalle(model, redirectAttributes,httpSession);
    }

}

