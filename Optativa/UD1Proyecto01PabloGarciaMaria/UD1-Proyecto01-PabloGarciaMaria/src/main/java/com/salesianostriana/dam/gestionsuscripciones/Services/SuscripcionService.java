package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Suscripcion.Nuevo_SuscripcionDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.SuscripcionRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SuscripcionService extends BaseServiceImpl<Suscripcion, Long, SuscripcionRepository> {

    @Lazy @Autowired
    private UsuarioService usuarioService;
    @Lazy @Autowired
    private PlanService planService;

    public String cambiarRenovacionAutomatica(Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        ValidacionResultado validacionResultado = ExtraMethods.comprobarSuscripcion(session, usuarioService, id, this);
        Suscripcion s;

        if (!validacionResultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", validacionResultado.getError());
            return validacionResultado.getRedirect();
        }

        s = (Suscripcion) validacionResultado.getObjeto();
        redirectAttributes.addFlashAttribute("message", "La renovación automática de la suscripción al plan " + s.getPlan().getNombre() + " ha sido " + (s.isRenovacionAutomatica() ? "desactivada." : "activada."));
        s.setRenovacionAutomatica(!s.isRenovacionAutomatica());
        save(s);
        return "redirect:/dashboard";
    }

    @Builder
    record ListarPlataforma_SuscripcionDTO(Long id, String nombre) {
        public static ListarPlataforma_SuscripcionDTO toDTO(Plataforma p) {
            return ListarPlataforma_SuscripcionDTO.builder()
                    .id(p.getId())
                    .nombre(p.getNombre())
                    .build();
        }
    }

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
        Usuario uDueno;
        List<ListarPlataforma_SuscripcionDTO> listaDTO;

        if (!validacionResultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", validacionResultado.getError());
            return validacionResultado.getRedirect();
        }

        uDueno = (Usuario) validacionResultado.getObjeto();
        if (suscripcionDTO == null) {
            suscripcionDTO = new Nuevo_SuscripcionDTO();
        }

        listaDTO = uDueno.getPlataformas().stream()
                .filter(p -> !p.checkActiveSuscription())
                .distinct()
                .map(ListarPlataforma_SuscripcionDTO::toDTO)
                .toList();

        System.out.println(listaDTO);

        if (listaDTO.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "No tienes plataformas para crear suscripciones.");
            return "redirect:/dashboard";
        }

        model.addAttribute("crear", true);
        model.addAttribute("suscripcion", suscripcionDTO);
        model.addAttribute("plataformas", listaDTO);

        System.out.println(suscripcionDTO);

        if (suscripcionDTO.getPlataformaId() != null) {
            Nuevo_SuscripcionDTO finalSuscripcionDTO = suscripcionDTO;
            Plataforma p = uDueno.getPlataformas().stream().filter(plataforma -> plataforma.getId().equals(finalSuscripcionDTO.getPlataformaId())).findFirst().orElse(null);
            if (p != null) {
                model.addAttribute("planListo", true);
                model.addAttribute("planes", p.getPlanes().stream().map(ListarPlan_SuscripcionDTO::toDTO).toList());
            } else {
                redirectAttributes.addFlashAttribute("error", "No tienes acceso a la plataforma seleccionada.");
                return nuevo(model, session, redirectAttributes, suscripcionDTO);
            }
        }

        return "suscripcion/formulario";
    }

    public String crear(Model model, HttpSession session, RedirectAttributes redirectAttributes, Nuevo_SuscripcionDTO suscripcionDTO) {
        ValidacionResultado validacionResultado = ExtraMethods.comprobarSesion(session, usuarioService);
        Optional<Plan> p;
        Usuario usuarioObjetivo;

        if (suscripcionDTO.getPlanId() == null) {
            if (model.containsAttribute("planListo")) {
                model.addAttribute("error", "Debes seleccionar un plan.");
            }
            return nuevo(model, session, redirectAttributes, suscripcionDTO);
        }

        if (!validacionResultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", validacionResultado.getError());
            return validacionResultado.getRedirect();
        }
        usuarioObjetivo = (Usuario) validacionResultado.getObjeto();

        p = planService.findById(suscripcionDTO.getPlanId());

        if (p.isEmpty()) {
            model.addAttribute("error", "El plan seleccionado no existe.");
            return nuevo(model, session, redirectAttributes, suscripcionDTO);
        }

        validacionResultado = crearSuscripcionRecursiva(LocalDate.parse(suscripcionDTO.getFechaInicio()),p.get(), usuarioObjetivo,suscripcionDTO.getAutoRenovacion());

        if (!validacionResultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", validacionResultado.getError());
            return validacionResultado.getRedirect();
        }


        redirectAttributes.addFlashAttribute("message", "Suscripción/es creada correctamente.");
        return "redirect:/dashboard";

    }

    public ValidacionResultado crearSuscripcionRecursiva(LocalDate fechaProcesada, Plan p, Usuario u, Boolean autoRenov) {
        ValidacionResultado resultado = new ValidacionResultado();

        if (!Objects.equals(p.getPlataforma().getUsuario().getId(), u.getId())) {
            resultado.setExito(false);
            resultado.setError("No tienes permiso para añadir suscripciones de la plataforma " + p.getPlataforma().getNombre() + ".");
            resultado.setRedirect("redirect:/dashboard");
            return resultado;
        }


        if (fechaProcesada != null) {
            do {
                Suscripcion s = Suscripcion.builder()
                        .fechaInicio(fechaProcesada)
                        .fechaFin(fechaProcesada.plus(p.getFrecuencia()))
                        .plan(p)
                        .usuario(u)
                        .renovacionAutomatica(autoRenov)
                        .build();
                s.setActiva(s.getFechaFin().isAfter(LocalDate.now()) || s.getFechaFin().isEqual(LocalDate.now()));
                fechaProcesada = fechaProcesada.plus(p.getFrecuencia());
                u.addSuscripcion(s);
                p.addSuscripcion(s);
                this.save(s);
            } while (fechaProcesada.isBefore(LocalDate.now()) && autoRenov);
        }

        u.addPlataforma(p.getPlataforma());

        resultado.setExito(true);
        return resultado;
    }
}
