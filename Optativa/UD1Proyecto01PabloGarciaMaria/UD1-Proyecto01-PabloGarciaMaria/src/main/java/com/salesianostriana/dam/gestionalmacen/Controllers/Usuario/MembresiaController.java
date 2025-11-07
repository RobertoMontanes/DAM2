package com.salesianostriana.dam.gestionalmacen.Controllers.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia.Nuevo_MembresiaDTO;
import com.salesianostriana.dam.gestionalmacen.Services.Usuario.MembresiaService;
import com.salesianostriana.dam.gestionalmacen.Services.Usuario.MembresiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/membresias")
@RequiredArgsConstructor
public class MembresiaController {

    private final MembresiaService service;

    @GetMapping
    public String listar(Model model) {
        return service.listar(model);
    }

    @GetMapping("/{id}")
    public String ver(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        return service.ver(model,id,redirectAttributes);
    }

    @GetMapping("/nueva")
    public String nuevo(Model model) {
        return service.nuevo(model,null);
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id,RedirectAttributes redirectAttributes) {
        return service.editar(model,id,redirectAttributes);
    }

    @PostMapping
    public String crear(Model model, @ModelAttribute("membresia") Nuevo_MembresiaDTO membresiaDTO, RedirectAttributes redirectAttributes) throws Exception {
        return service.crear(model,membresiaDTO,redirectAttributes);
    }

    @PutMapping
    public String actualizar(Model model,@ModelAttribute("membresia") Nuevo_MembresiaDTO membresiaDTO, RedirectAttributes redirectAttributes) throws Exception {
        return service.actualizar(model, membresiaDTO, redirectAttributes);
    }

    @DeleteMapping("/{id}")
    public String eliminar(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        return service.eliminar(model,id,redirectAttributes);
    }

}
