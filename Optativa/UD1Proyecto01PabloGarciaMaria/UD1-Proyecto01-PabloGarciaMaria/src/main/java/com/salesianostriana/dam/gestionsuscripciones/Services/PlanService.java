package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plan.Nuevo_PlanDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.PlanRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class PlanService extends BaseServiceImpl<Plan,Long, PlanRepository> {

    private final ExtraMethods extraMethods;

    public String nuevo(Model model,HttpSession session, RedirectAttributes redirectAttributes, Nuevo_PlanDTO planDTO) {
        Long idPlataforma = (Long) model.getAttribute("idPlataforma");
        ValidacionResultado resultado = extraMethods.comprobarPlataforma(session, idPlataforma);

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        if (planDTO == null) {
            planDTO = new Nuevo_PlanDTO();
        }

        model.addAttribute("planDTO", planDTO);
        model.addAttribute("crear", true);

        return "planes/formulario";
    }

    // EXTRAS
}
