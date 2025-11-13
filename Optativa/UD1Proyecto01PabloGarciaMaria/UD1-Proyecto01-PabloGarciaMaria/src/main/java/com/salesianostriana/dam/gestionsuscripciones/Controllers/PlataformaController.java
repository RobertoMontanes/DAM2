package com.salesianostriana.dam.gestionsuscripciones.Controllers;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Formulario_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Nuevo_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Services.PlataformaService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/plataformas")
@RequiredArgsConstructor
public class PlataformaController {

    private final PlataformaService service;

    @GetMapping("/nuevo")
    public String nuevo(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        return service.nuevo(model,session,redirectAttributes,null);
    }

    @PostMapping()
    public String crear(@ModelAttribute(name = "formulario") Nuevo_PlataformaDTO formularioDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        return service.crear(formularioDTO,session,redirectAttributes);
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, HttpSession session, RedirectAttributes redirectAttributes, @PathVariable Long id) {
        return service.editar(model,session,redirectAttributes,null, id);
    }

    @PutMapping()
    public String actualizar(@ModelAttribute(name = "formulario") Formulario_PlataformaDTO formularioDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        return service.actualizar(formularioDTO,session,redirectAttributes);
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        return service.eliminar(id,session,redirectAttributes);
    }

    @GetMapping("/{id}")
    public String verDetalle(@PathVariable Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        return service.verDetalle(id,model,session,redirectAttributes);
    }

    @GetMapping("/{id}/planes/nuevo")
    public String nuevoPlan(@PathVariable Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        return service.nuevoPlan(id,model,session,redirectAttributes);
    }

}
