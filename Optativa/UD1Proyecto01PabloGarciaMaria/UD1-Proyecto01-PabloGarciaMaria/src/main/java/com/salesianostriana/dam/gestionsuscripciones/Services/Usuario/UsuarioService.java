package com.salesianostriana.dam.gestionsuscripciones.Services.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.DTO.Usuario.Listar_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.DTO.Usuario.Nuevo_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

        public String listar(Model model) {
            model.addAttribute("usuarios", findAll().stream().map(Listar_UsuarioDTO::toDTO).toList());

            return "admin/listarUsuario";
        }

    public String ver(Model model, Long id, RedirectAttributes redirectAttributes) {
        Optional<Usuario> usuario = findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", Listar_UsuarioDTO.toDTO(usuario.get()));
            return "usuario/dashboard";
        } else {
            redirectAttributes.addFlashAttribute("error", "El usuario con ID " + id + " no existe.");
            return "redirect:/usuarios";
        }
    }
}
