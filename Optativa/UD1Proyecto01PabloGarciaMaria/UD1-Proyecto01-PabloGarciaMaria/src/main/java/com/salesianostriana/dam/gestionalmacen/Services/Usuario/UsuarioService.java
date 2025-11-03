package com.salesianostriana.dam.gestionalmacen.Services.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Listar_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Nuevo_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Almacen.AlmacenService;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    private final AlmacenService almacenService;
    private final MembresiaService membresiaService;

    public String listar(Model model) {
        model.addAttribute("usuarios", findAll().stream().map(Listar_UsuarioDTO::toDTO).toList());
        return "Usuario/Listar";
    }

    public String nuevo(Model model, Nuevo_UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            usuarioDTO = new Nuevo_UsuarioDTO();
        }
        model.addAttribute("usuario", usuarioDTO);
        model.addAttribute("crear", true);
        return "Usuario/Formulario";
    }

    public String crear(Model model, Nuevo_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes) {
        Usuario u = usuarioDTO.fromDTO();
        save(u);
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/usuarios";
    }

    public String actualizar(Model model, Nuevo_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes) {
        Optional<Usuario> uOpt = findById(usuarioDTO.getId());
        Usuario uOrg;
        if (uOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return "redirect:/usuarios";
        }
        uOrg = uOpt.get();
        if (usuarioDTO.getPassword().isEmpty()) {
            usuarioDTO.setPassword(uOrg.getPassword());
        }
        save(uOrg.modify(usuarioDTO.fromDTO()));
        redirectAttributes.addFlashAttribute("success", "Usuario editado correctamente");
        return "redirect:/usuarios";
    }

    public String eliminar(Model model, Long id, RedirectAttributes redirectAttributes) {
        Usuario u = findById(id).orElse(null);
        if (u == null) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return "redirect:/usuarios";
        }
        for (Almacen almacen : u.getAlmacenesAsignados()) {
            almacen.setUsuario(null);
            almacenService.save(almacen);
        }
        u.getHistorialSubscripciones().forEach(membresiaService::delete);
        delete(u);
        redirectAttributes.addFlashAttribute("success", "Usuario eliminado correctamente");
        return "redirect:/usuarios";
    }

    public String editar(Model model, Integer id) {
        Usuario u = findById(Long.valueOf(id)).orElseThrow();
        model.addAttribute("usuario", Nuevo_UsuarioDTO.toDTO(u));
        model.addAttribute("crear", false);
        return "Usuario/Formulario";
    }

    public String ver(Model model, Long id, RedirectAttributes redirectAttributes) {
        Usuario u = findById(id).orElse(null);
        if (u == null){
            redirectAttributes.addFlashAttribute("error","Usuario no encontrado");
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario", Listar_UsuarioDTO.toDTO(u));
        return "Usuario/Detalles";
    }
}
