package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Formulario_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Nuevo_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Objetivo;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
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
    private final PlanService planService;

    // CRUD PLATAFORMA

    public String nuevo(Model model, HttpSession session, RedirectAttributes redirectAttributes, Nuevo_PlataformaDTO formularioDTO) {
        ValidacionResultado resultado = comprobarSesion(session,null,Objetivo.CREAR);;

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        if ( formularioDTO == null) {
            formularioDTO = new Nuevo_PlataformaDTO();
        }

        model.addAttribute("plataforma", formularioDTO);
        model.addAttribute("crear", true);
        return "plataforma/formulario";
    }

    public String crear(Nuevo_PlataformaDTO plataformaDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        ValidacionResultado resultado = comprobarSesion(session,null,Objetivo.CREAR);;
        Long id = (Long) session.getAttribute("id");
        Usuario u;


        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        u = (Usuario) resultado.getObjeto();

        if (plataformaDTO == null) {
            redirectAttributes.addFlashAttribute("error", "Algo ha fallado durante el envío del formulario.");
            return "redirect:/plataformas/nuevo";
        }

        Plataforma p = plataformaDTO.fromDTO();
        p.setUsuario(u);
        save(p);

        u.addPlataforma(p);
        usuarioService.save(u);

        return "redirect:/usuarios/" + id;
    }

    public String editar(Model model, HttpSession session, RedirectAttributes redirectAttributes, Formulario_PlataformaDTO o, Long id) {
        Plataforma p;
        ValidacionResultado resultado = comprobarSesion(session, id,Objetivo.ACTUALIZAR);

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        p = (Plataforma) resultado.getObjeto();
        model.addAttribute("plataforma", p);
        model.addAttribute("crear", false);
        return "plataforma/formulario";

    }

    public String actualizar(Formulario_PlataformaDTO formularioDTO, HttpSession session, RedirectAttributes redirectAttributes) {
        Plataforma p;
        ValidacionResultado resultado = comprobarSesion(session, formularioDTO.getId(), Objetivo.ACTUALIZAR);

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        p = (Plataforma) resultado.getObjeto();

        p.modify(formularioDTO.fromDTO());
        save(p);
        return "redirect:/usuarios/" + session.getAttribute("id");
    }

    // EXTRAS:

    private ValidacionResultado comprobarSesion(HttpSession session, Long idPlataforma, Objetivo objetivo) {
        ValidacionResultado resultado = new ValidacionResultado();
        Long idUsuario = (Long) session.getAttribute("id");
        Optional<Usuario> uOpt;

        if (idUsuario == null) {
            resultado.setError("No puedes trabajar con plataformas sin antes haber iniciado sesion.");
            resultado.setRedirect("redirect:/usuarios");
            return resultado;
        }

        uOpt = usuarioService.findById(idUsuario);
        if (uOpt.isEmpty()) {
            resultado.setError("Estas intentando trabajar con un usuario inexistente.");
            resultado.setRedirect("redirect:/usuarios");
            return resultado;
        }

        if (objetivo == Objetivo.CREAR) {
            resultado.setObjeto(uOpt.get());
        }

        if (objetivo == Objetivo.ACTUALIZAR) {
            if (uOpt.get().findPlataformaById(idPlataforma)) {
                resultado.setError("No puedes editar una plataforma que no te pertenece.");
                resultado.setRedirect("redirect:/usuarios/" + idPlataforma);
                return resultado;
            }

            Optional<Plataforma> pOpt = findById(idPlataforma);
            if (pOpt.isEmpty()) {
                resultado.setError("No se ha encontrado la plataforma solicitada.");
                resultado.setRedirect("redirect:/usuarios/" + idPlataforma);
                return resultado;
            }

            resultado.setObjeto(pOpt.get());
        }

        resultado.setExito(true);
        return resultado;
    }

}
