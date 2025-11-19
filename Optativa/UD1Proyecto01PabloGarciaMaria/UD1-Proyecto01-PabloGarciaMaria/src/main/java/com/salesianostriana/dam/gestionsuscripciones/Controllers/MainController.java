package com.salesianostriana.dam.gestionsuscripciones.Controllers;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.LogIn_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Services.MainService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class MainController {

    private final MainService service;

    @GetMapping("")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session, RedirectAttributes redirectAttributes, @RequestParam(required = false, defaultValue = "0") Long page,
                            @RequestParam(required = false, defaultValue = "5") Long size,
                            @RequestParam(required = false) String q) {
        return service.redirectToDashboard(model, session, redirectAttributes, page ,size, q);
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session,  RedirectAttributes redirectAttributes) {
        return service.logOut(session,redirectAttributes);
    }

    @GetMapping("/login")
    public String logIn(Model model, HttpSession session) {
        return service.logIn(model,null,session);
    }

    @PostMapping("/login")
    public String checkLogIn(Model model, LogIn_UsuarioDTO logIn_usuarioDTO, HttpSession session) {
        return service.checkLogIn(model,logIn_usuarioDTO,session);
    }

    @GetMapping("/entrarya")
    public String entrarYa(Model model, HttpSession session) {
        return service.checkLogIn(model,new LogIn_UsuarioDTO("pruebas@gmail.com","1234"),session);
    }

    @GetMapping ("/register")
    public String register(Model model) {
        return service.register(null, model);
    }
}
