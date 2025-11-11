package com.salesianostriana.dam.gestionalmacen.Controllers.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.TipoAlmacen.Nuevo_TipoAlmacenDTO;
import com.salesianostriana.dam.gestionalmacen.Services.Almacen.TipoAlmacenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/almacenes/tipos")
public class TipoAlmacenController {

    private final TipoAlmacenService service;

    @GetMapping
    public String listar(Model model) {
        return service.listar(model);
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
    public String crear(Model model, @ModelAttribute("tipoAlmacen") Nuevo_TipoAlmacenDTO tipoAlmacenDTO, RedirectAttributes redirectAttributes) throws Exception {
        return service.crear(model,tipoAlmacenDTO,redirectAttributes);
    }

    @PutMapping
    public String actualizar(Model model,@ModelAttribute("tipoAlmacen") Nuevo_TipoAlmacenDTO tipoAlmacenDTO, RedirectAttributes redirectAttributes) throws Exception {
        return service.actualizar(model, tipoAlmacenDTO, redirectAttributes);
    }

    @DeleteMapping("/{id}")
    public String eliminar(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        return service.eliminar(model,id,redirectAttributes);
    }


}
