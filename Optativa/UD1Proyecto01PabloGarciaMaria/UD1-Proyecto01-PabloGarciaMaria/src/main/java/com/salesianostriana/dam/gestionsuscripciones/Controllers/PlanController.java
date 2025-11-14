package com.salesianostriana.dam.gestionsuscripciones.Controllers;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plan.Editar_PlanDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plan.Nuevo_PlanDTO;
import com.salesianostriana.dam.gestionsuscripciones.Services.PlanService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/planes")
@RequiredArgsConstructor
public class PlanController {

    private final PlanService service;

    @GetMapping("/nuevo")
    public String nuevo(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        return service.nuevo(model,session,redirectAttributes, null);
    }

    @PostMapping
    public String crear(Model model, HttpSession session, RedirectAttributes redirectAttributes, @ModelAttribute(name = "plan")Nuevo_PlanDTO planDTO) {
        return service.crear(model,session,redirectAttributes, planDTO);
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, HttpSession session, RedirectAttributes redirectAttributes, @PathVariable Long id) {
        return service.editar(model,session,redirectAttributes,null, id);
    }

    @PutMapping
    public String actualizar(@ModelAttribute(name = "plan") Editar_PlanDTO planDTO, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
        return service.actualizar(planDTO,session,redirectAttributes, model);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        return service.eliminar(id,session,redirectAttributes);
    }

}
