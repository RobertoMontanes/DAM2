package com.salesianostriana.dam.gestionalmacen.Controllers;


import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.NuevoProducto_DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.salesianostriana.dam.gestionalmacen.Services.ProductoService;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService service;

    @GetMapping
    public String listar(Model model) {
        return service.listar(model);
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        return service.nuevo(model);
    }

    @PostMapping
    public String crear(@ModelAttribute(name = "producto") NuevoProducto_DTO productoDTO, RedirectAttributes redirectAttributes, Model model) {
        return service.crear(productoDTO,redirectAttributes);
    }

}
