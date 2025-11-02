package com.salesianostriana.dam.gestionalmacen.Controllers.WEB;

import ch.qos.logback.core.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.salesianostriana.dam.gestionalmacen.Services.WEB.Producto.ProductoService;

@Controller
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService service;

    @GetMapping
    public String listar(Model model) {
        return service.listar(model);
    }

}
