package com.salesianostriana.dam.gestionsuscripciones.Controllers;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Suscripcion.Nuevo_SuscripcionDTO;
import com.salesianostriana.dam.gestionsuscripciones.Services.SuscripcionService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/suscripciones")
public class SuscripcionController {

    private final SuscripcionService service;

    @GetMapping("/nuevo")
    public String nuevo(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        System.out.println("GET PETO");
        return service.nuevo(model, session, redirectAttributes, null);
    }

    @PostMapping()
    public String crear(Model model, HttpSession session, RedirectAttributes redirectAttributes, @ModelAttribute Nuevo_SuscripcionDTO suscripcionDTO) {
        System.out.println("PostMapping");
        return service.crear(model, session, redirectAttributes, suscripcionDTO);
    }

}
