package com.salesianostriana.dam.gestionalmacen.Controllers.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

    @GetMapping
    public String index() {
        return "Principal/index";
    }

}
