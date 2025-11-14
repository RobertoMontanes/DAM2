package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plan.Editar_PlanDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plan.Nuevo_PlanDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.PlanRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class PlanService extends BaseServiceImpl<Plan,Long, PlanRepository> {

    private final PlataformaService plataformaService;
    private final UsuarioService usuarioService;

    public String nuevo(Model model,HttpSession session, RedirectAttributes redirectAttributes, Nuevo_PlanDTO planDTO) {
        Long idPlataforma = (Long) session.getAttribute("idPlataforma");
        ValidacionResultado resultado = ExtraMethods.comprobarPlataforma(session, idPlataforma, usuarioService, plataformaService);

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        if (planDTO == null) {
            planDTO = new Nuevo_PlanDTO();
        }

        model.addAttribute("plan", planDTO);
        model.addAttribute("crear", true);

        return "planes/formulario";
    }

    public String crear(Model model, HttpSession session, RedirectAttributes redirectAttributes, Nuevo_PlanDTO planDTO) {
        Long idPlataforma = (Long) session.getAttribute("idPlataforma");
        ValidacionResultado resultado = ExtraMethods.comprobarPlataforma(session, idPlataforma, usuarioService, plataformaService);
        Plan plan;
        Plataforma p;

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        p = (Plataforma) resultado.getObjeto();

        plan = planDTO.fromDTO();
        plan.setPlataforma(p);

        save(plan);

        p.getPlanes().add(plan);
        plataformaService.save(p);

        return "redirect:/plataformas/" + idPlataforma;
    }

    public String editar(Model model, HttpSession session, RedirectAttributes redirectAttributes, Editar_PlanDTO o, Long id) {
        Long idPlataforma = (Long) session.getAttribute("idPlataforma");
        ValidacionResultado resultado = ExtraMethods.comprobarPlataforma(session, idPlataforma, usuarioService, plataformaService);
        Plan plan;

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        plan = (Plan) resultado.getObjeto();



    }

    public String actualizar(Editar_PlanDTO planDTO, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
    }

    public String eliminar(Long id, HttpSession session, RedirectAttributes redirectAttributes) {
    }

    // EXTRAS
}
