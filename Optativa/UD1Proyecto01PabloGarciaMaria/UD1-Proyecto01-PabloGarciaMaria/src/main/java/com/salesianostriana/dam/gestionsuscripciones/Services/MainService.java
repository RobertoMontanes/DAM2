package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.LogIn_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final UsuarioService usuarioService;

    public String logOut(HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getId() != null && session.getAttribute("id") != null) {
            session.setAttribute("id", null);
            redirectAttributes.addFlashAttribute("message", "Has cerrado sesión correctamente.");
        }
        return "redirect:/login";
    }

    public String logIn(Model model, LogIn_UsuarioDTO logIn_usuarioDTO, HttpSession session) {

        if (session.getId() != null && session.getAttribute("id") != null) {
            return "redirect:/usuarios";
        }

        if (logIn_usuarioDTO == null) {
            logIn_usuarioDTO = new LogIn_UsuarioDTO();
        }

        model.addAttribute("usuario", logIn_usuarioDTO);


        return "main/login";
    }

    public String checkLogIn(Model model, LogIn_UsuarioDTO logIn_usuarioDTO, HttpSession session) {
        List<Usuario> findAll = usuarioService.findAll();
        List<Usuario> filtered = findAll.stream().filter(u ->
                u.getEmail().equals(logIn_usuarioDTO.getEmail()
                )).toList();

        if (filtered.isEmpty()) {
            model.addAttribute("error", "Usuario o contraseña incorrectos.");
            return logIn(model, logIn_usuarioDTO,session);
        } else {
            Usuario u = filtered.getFirst();
            if (u.getPassword().equals(logIn_usuarioDTO.getPassword())) {
                if (u.isActivo()) {
                    session.setAttribute("id", u.getId());
                    return "redirect:/usuarios";
                } else {
                    model.addAttribute("error", "El usuario no está activo. Contacte con el administrador.");
                    return logIn(model, logIn_usuarioDTO,session);
                }
            } else {
                model.addAttribute("error", "Usuario o contraseña incorrectos.");
                return logIn(model, logIn_usuarioDTO,session);
            }
        }



    }

}
