package com.salesianostriana.dam.gestionsuscripciones.Services.Usuario;

import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.DTO.Usuario.Listar_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.DTO.Usuario.Formulario_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    public String listar(Model model) {
        model.addAttribute("usuarios", findAll().stream().map(Listar_UsuarioDTO::toDTO).toList());

        return "admin/usuario/listar";
    }

    public String nuevo(Model model, Formulario_UsuarioDTO usuarioDTO) {

        if (usuarioDTO == null) {
            usuarioDTO = new Formulario_UsuarioDTO();
        }

        model.addAttribute("crear", true);
        model.addAttribute("usuario", usuarioDTO);

        return "admin/usuario/formulario";
    }

    public String crear(Formulario_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes, Model model) {

        if (usuarioDTO == null) {
            redirectAttributes.addAttribute("error", "Algo ha fallado durante el envío del formulario.");
            return    "redirect:/usuarios/nuevo";
        }

        Usuario u = usuarioDTO.fromDTO();
        u.setId(null); // Evitamos la modificacion en caso de error desde el front.
        save(u);


        return "redirect:/usuarios";
    }

    public String cambiarEstado(Long id, RedirectAttributes redirectAttributes) {

        Optional<Usuario> u = findById(id);
        if (u.isPresent()) {
            u.get().cambiarEstado();
            save(u.get());
            redirectAttributes.addFlashAttribute("success", "El estado del usuario ha sido modificado correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("error", "No se ha encontrado el usuario solicitado.");
        }

        return "redirect:/usuarios";
    }

    public String editar(Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Usuario> u = findById(id);
        if (u.isPresent()) {
            model.addAttribute("usuario", Formulario_UsuarioDTO.toDTO(u.get()));
            model.addAttribute("crear", false);
            return "admin/usuario/formulario";
        } else {
            redirectAttributes.addFlashAttribute("error", "No se ha encontrado el usuario solicitado.");
            return "redirect:/usuarios";
        }
    }

    public String actualizar(Formulario_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes, Model model) {
        Optional<Usuario> uOpt = findById(usuarioDTO.getId());
        Usuario uOrg;
        if (uOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return "redirect:/usuarios";
        }
        uOrg = uOpt.get();
        if (usuarioDTO.getPassword() == null || usuarioDTO.getPassword().isEmpty()) {
            usuarioDTO.setPassword(uOrg.getPassword());
        }
        save(uOrg.modify(usuarioDTO.fromDTO()));
        redirectAttributes.addFlashAttribute("success", "Usuario editado correctamente");
        return "redirect:/usuarios";
    }

    public String verDetalle(Long id, Model model, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("info","Funcionalidad en desarrollo.");
        return "redirect:/usuarios";
    }
}
