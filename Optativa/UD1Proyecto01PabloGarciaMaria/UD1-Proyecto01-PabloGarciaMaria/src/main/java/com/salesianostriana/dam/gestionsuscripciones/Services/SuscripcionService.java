package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Suscripcion.Nuevo_SuscripcionDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.SuscripcionRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Service
public class SuscripcionService extends BaseServiceImpl<Suscripcion, Long, SuscripcionRepository> {

    @Lazy @Autowired
    private UsuarioService usuarioService;
    @Lazy @Autowired
    private PlanService planService;

    public void comprobarVencimientos(Usuario usuario) {
        List<Suscripcion> suscripciones = usuario.getSuscripciones().stream().filter(Suscripcion::isActiva).toList();

        for (Suscripcion s : suscripciones) {
                if (s.getFechaFin().isBefore(LocalDate.now())) {
                    s.setActiva(false);
                    save(s);

                    if (s.isRenovacionAutomatica()) {
                        Plan plan = s.getPlan();
                        Suscripcion nuevaSuscripcion = Suscripcion.builder()
                                .usuario(usuario)
                                .plan(plan)
                                .fechaInicio(LocalDate.now())
                                .fechaFin(LocalDate.now().plus(plan.getFrecuencia()))
                                .activa(true)
                                .renovacionAutomatica(s.isRenovacionAutomatica())
                                .build();
                        save(nuevaSuscripcion);

                        usuario.addSuscripcion(nuevaSuscripcion);
                        usuarioService.save(usuario);

                        plan.addSuscripcion(nuevaSuscripcion);
                        planService.save(plan);
                    }

                }
        }

    }

    @Builder
    record ListarPlan_SuscripcionDTO(String nombre, Long id){
        public static ListarPlan_SuscripcionDTO toDTO(Plan plan) {
            return ListarPlan_SuscripcionDTO.builder()
                    .nombre(plan.getNombre())
                    .id(plan.getId())
                    .build();
        }
    }

    public String nuevo(Model model, HttpSession session, RedirectAttributes redirectAttributes, Nuevo_SuscripcionDTO suscripcionDTO) {
        ValidacionResultado validacionResultado = ExtraMethods.comprobarSesion(session, usuarioService);

        if (!validacionResultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", validacionResultado.getError());
            return validacionResultado.getRedirect();
        }

        if (suscripcionDTO == null) {
            suscripcionDTO = new Nuevo_SuscripcionDTO();
        }

        model.addAttribute("crear", true);
        model.addAttribute("suscripcion", suscripcionDTO);
        model.addAttribute("planes", planService.findAll().stream().filter(Plan::getActivo).map(ListarPlan_SuscripcionDTO::toDTO).toList());

        return "suscripcion/formulario";
    }

    public String crear(Model model, HttpSession session, RedirectAttributes redirectAttributes, Nuevo_SuscripcionDTO suscripcionDTO) {
        return "despues lo hago";
    }
}
