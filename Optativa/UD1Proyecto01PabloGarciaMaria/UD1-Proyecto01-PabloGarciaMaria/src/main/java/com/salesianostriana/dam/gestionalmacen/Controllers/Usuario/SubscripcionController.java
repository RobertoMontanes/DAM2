package com.salesianostriana.dam.gestionalmacen.Controllers.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.Nuevo_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Nuevo_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Services.Usuario.SubscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/subscripciones")
public class SubscripcionController {

    private final SubscripcionService service;

    @GetMapping
    public String listar(Model model, @RequestParam(defaultValue = "10", required = false) int size,
                         @RequestParam(required = false) String searchTerm,
                         @RequestParam(required = false) Double precioMin,
                         @RequestParam(required = false) Double precioMax,
                         @RequestParam(required = false) Integer almacenesMin,
                         @RequestParam(required = false) Boolean soportePrioritario,
                         @RequestParam(required = false, defaultValue = "1") Integer page
                         ) {
        return service.listar(model, size, searchTerm, precioMin, precioMax, almacenesMin, soportePrioritario, page);
    }

    @GetMapping("/{id}")
    public String ver(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        return service.ver(model,id,redirectAttributes);
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        return service.nuevo(model,null);
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id,RedirectAttributes redirectAttributes) {
        return service.editar(model,id,redirectAttributes);
    }

    @PostMapping
    public String crear(Model model, @ModelAttribute("subscripcion") Nuevo_SubscripcionDTO subscripcionDTO, RedirectAttributes redirectAttributes) {
        return service.crear(model,subscripcionDTO,redirectAttributes);
    }

    @PutMapping
    public String actualizar(Model model,@ModelAttribute("subscripcion") Nuevo_SubscripcionDTO subscripcionDTO, RedirectAttributes redirectAttributes) {
        return service.actualizar(model, subscripcionDTO, redirectAttributes);
    }

    @DeleteMapping("/{id}")
    public String eliminar(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        return service.eliminar(model,id,redirectAttributes);
    }


}
