package com.salesianostriana.dam.gestionsuscripciones.Controllers;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Formulario_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Nuevo_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Services.PlataformaService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.TE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/plataformas")
@RequiredArgsConstructor
public class PlataformaController {

//    HAY QUE METERLE:
//1. CREAR EL PLAN POR DEFECTO JUNTO CON LA PLATAFORMA
//    2. ELIMINAR (DESACTIVAR) PLATAFORMAS
//    3. YA DESPUES DE ESO TE PONES A TRABAJAR CON LOS PLANES
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

}
