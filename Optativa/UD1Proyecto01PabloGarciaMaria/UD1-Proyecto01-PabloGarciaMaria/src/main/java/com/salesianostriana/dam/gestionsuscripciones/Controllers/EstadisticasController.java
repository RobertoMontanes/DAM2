package com.salesianostriana.dam.gestionsuscripciones.Controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.salesianostriana.dam.gestionsuscripciones.Services.EstadisticasService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/estadisticas")
@Controller
@RequiredArgsConstructor
public class EstadisticasController {

    private final EstadisticasService service;

    @GetMapping()
    public String estadisticas(Model model, RedirectAttributes redirectAttributes, HttpSession session,
                                @RequestParam(required = false, defaultValue = "30") int periodo,
                                @RequestParam(required = false, defaultValue = "all") String categoria,
                                @RequestParam(required = false, defaultValue = "all") String plataforma

    ) throws JsonProcessingException {
        return service.cargarEstadisticas(model, redirectAttributes, session, periodo, categoria, plataforma);
    }

}
