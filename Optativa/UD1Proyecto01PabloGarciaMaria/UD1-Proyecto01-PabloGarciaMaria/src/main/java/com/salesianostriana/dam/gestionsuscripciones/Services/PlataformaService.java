package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Formulario_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.PlataformaRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlataformaService extends BaseServiceImpl<Plataforma, Long, PlataformaRepository> {

    private final UsuarioService usuarioService;


    public String nuevo(Model model, HttpSession session, RedirectAttributes redirectAttributes,Formulario_PlataformaDTO formularioDTO) {
        Long id = (Long) session.getAttribute("id");
        if (id == null) {
            return comprobarSesion(session, redirectAttributes);
        } else {

            if ( formularioDTO == null) {
                formularioDTO = new Formulario_PlataformaDTO();
            }

            model.addAttribute("plataforma", formularioDTO);
            model.addAttribute("crear", true);
            return "plataforma/formulario";
        }
    }

    private String comprobarSesion(HttpSession session, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "No puedes trabajar con plataformas sin antes haber iniciado sesion.");
        return "redirect:/usuarios";
    }

    public String crear(Formulario_PlataformaDTO formularioDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        Long id = (Long) session.getAttribute("id");
        Optional<Usuario> uOpt;
        if (id == null) {
            return comprobarSesion(session, redirectAttributes);
        } else {

            if (formularioDTO == null) {
                redirectAttributes.addFlashAttribute("error", "Algo ha fallado durante el envío del formulario.");
                return "redirect:/plataformas/nuevo";
            }

            uOpt = usuarioService.findById(id);
            if (uOpt.isEmpty()) {
                redirectAttributes.addFlashAttribute("error", "Estas intentando trabajar con un usuario inexistente.");
                return "redirect:/usuarios";
            }

            Plataforma p = formularioDTO.fromDTO();
            p.setId(null); // Evitamos la modificacion en caso de error desde el front.
            p.setUsuario(uOpt.get());
            save(p);

            uOpt.get().addPlataforma(p);
            usuarioService.save(uOpt.get());

            return "redirect:/usuarios/" + id;
        }
    }

//    HABLAR CON ANGEL A VER SI SE LE OCURRE ALGUNA FORMA DE HACER LAS COMPROBACIONES SIN REPETIR
    // Lo he hablado con el chatGPT y te dice que crees una clase auxiliar, no es mala idea pero no se....
    public String editar(Model model, HttpSession session, RedirectAttributes redirectAttributes, Formulario_PlataformaDTO o, Long id) {
        Long idUsuario = (Long) session.getAttribute("id");
        Optional<Usuario> uOpt;
        if (idUsuario == null) {
            return comprobarSesion(session, redirectAttributes);
        }
        uOpt = usuarioService.findById(idUsuario);
        if (uOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Estas intentando trabajar con un usuario inexistente.");
            return "redirect:/usuarios";
        }

        if (uOpt.get().findPlataformaById(id)) {
            redirectAttributes.addFlashAttribute("error", "No puedes editar una plataforma que no te pertenece.");
            return "redirect:/usuarios/" + id;
        }

        Optional<Plataforma> pOpt = findById(id);
        if (pOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "No se ha encontrado la plataforma solicitada.");
            return "redirect:/usuarios/" + id;
        }

        model.addAttribute("plataforma", pOpt.get());
        model.addAttribute("crear", false);
        return "plataforma/formulario";

    }

    public String actualizar(Formulario_PlataformaDTO formularioDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        Long idUsuario = (Long) session.getAttribute("id");
        Long id = formularioDTO.getId();
        Optional<Usuario> uOpt;

        if (idUsuario == null) {
            return comprobarSesion(session, redirectAttributes);
        }
        uOpt = usuarioService.findById(idUsuario);
        if (uOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Estas intentando trabajar con un usuario inexistente.");
            return "redirect:/usuarios";
        }

        if (uOpt.get().findPlataformaById(id)) {
            redirectAttributes.addFlashAttribute("error", "No puedes editar una plataforma que no te pertenece.");
            return "redirect:/usuarios/" + id;
        }

        Optional<Plataforma> pOpt = findById(id);
        if (pOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "No se ha encontrado la plataforma solicitada.");
            return "redirect:/usuarios/" + id;
        }

        pOpt.get().modify(formularioDTO.fromDTO());
        save(pOpt.get());
        return "redirect:/usuarios/" + idUsuario;

    }
}
