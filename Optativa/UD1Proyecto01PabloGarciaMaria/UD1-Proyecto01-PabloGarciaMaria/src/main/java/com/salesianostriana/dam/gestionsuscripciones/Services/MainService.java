package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.LogIn_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.Register_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MainService {

    private final UsuarioService usuarioService;
    private final PlataformaService plataformaService;
    private final PlanService planService;

    public String logOut(HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getId() != null && session.getAttribute("id") != null) {
            usuarioService.findById((Long) session.getAttribute("id")).ifPresent(usuario -> {
                usuario.setUltimaConexion(LocalDateTime.now());
                usuarioService.save(usuario);
            });
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
                    u.setUltimaConexion(LocalDateTime.now());
                    usuarioService.save(u);
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

    public String redirectToDashboard(Model model, HttpSession session, RedirectAttributes redirectAttributes,Long page, Long size, String query) {
        return usuarioService.verDetalle(model, redirectAttributes, session, page, size, query);
    }

    public String register(Register_UsuarioDTO usuarioDTO, Model model) {
        if (usuarioDTO == null) {
            usuarioDTO = new Register_UsuarioDTO();
        }

        // PROCESAR DATOS DE NUEVO USUARIO.

        model.addAttribute("usuario", usuarioDTO);
        return "main/register";
    }
}
