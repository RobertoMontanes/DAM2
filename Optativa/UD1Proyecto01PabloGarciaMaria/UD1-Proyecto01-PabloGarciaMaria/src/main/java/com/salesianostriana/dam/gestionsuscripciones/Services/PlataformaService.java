package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Detalles_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Extras.ListarPlanes_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Formulario_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Plataforma.Nuevo_PlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Categorias;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Objetivo;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.PlataformaRepository;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.SuscripcionRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class PlataformaService extends BaseServiceImpl<Plataforma, Long, PlataformaRepository> {

    @Autowired
    private UsuarioService usuarioService;

    @Lazy @Autowired
    private PlanService planService;
    @Lazy @Autowired
    private SuscripcionService suscripcionService;
    @Autowired
    private SuscripcionRepository suscripcionRepository;

    // CRUD PLATAFORMA

    public String nuevo(Model model, HttpSession session, RedirectAttributes redirectAttributes, Nuevo_PlataformaDTO formularioDTO) {
        ValidacionResultado resultado = comprobarSesion(session, null, Objetivo.CREAR);

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        if (formularioDTO == null) {
            formularioDTO = new Nuevo_PlataformaDTO();
        }

        model.addAttribute("plataforma", formularioDTO);
        model.addAttribute("crear", true);
        model.addAttribute("categorias", Categorias.values());
        return "plataforma/formulario";
    }

    public String crear(Nuevo_PlataformaDTO plataformaDTO, HttpSession session, RedirectAttributes redirectAttributes, Model model) {
        ValidacionResultado resultado = comprobarSesion(session, null, Objetivo.CREAR);
        Plataforma p;
        Plan p2;
        Usuario u;
        LocalDate fechaProcesada;


        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        u = (Usuario) resultado.getObjeto();

        if (plataformaDTO.getFecha_suscripcion() != null && !plataformaDTO.getFecha_suscripcion().isEmpty()) {
            plataformaDTO.setFecha_suscripcion(LocalDate.parse(plataformaDTO.getFecha_suscripcion()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }

        if (plataformaDTO == null) {
            redirectAttributes.addFlashAttribute("error", "Algo ha fallado durante el envío del formulario.");
            return "redirect:/plataformas/nuevo";
        }

        if (plataformaDTO.getPlan().getFrecuencia_dias() <= 0 && plataformaDTO.getPlan().getFrecuencia_meses() <= 0 &&
                plataformaDTO.getPlan().getFrecuencia_anios() <= 0) {
            model.addAttribute("error", "Por favor, establece al menos una frecuencia de renovación (días, meses o años).");
            return this.nuevo(model, session, redirectAttributes, plataformaDTO);
        }

        if (plataformaDTO.getPlan().getPrecio() <= 0) {
            model.addAttribute("error", "El precio del plan debe ser mayor que 0.");
            return this.nuevo(model, session, redirectAttributes, plataformaDTO);
        }

        System.out.println(plataformaDTO);

        if (plataformaDTO.getCategoria() == null || plataformaDTO.getCategoria().isEmpty()) {
            model.addAttribute("error", "Por favor, selecciona una categoría para la plataforma.");
            return this.nuevo(model, session, redirectAttributes, plataformaDTO);
        }

        p = plataformaDTO.fromDTO();
        p.setUsuario(u);
        save(p);

        p2 = plataformaDTO.getPlan().fromDTO();
        p2.setPlataforma(p);
        planService.save(p2);

        p.getPlanes().add(p2);

        if (plataformaDTO.getFecha_suscripcion() != null && !plataformaDTO.getFecha_suscripcion().isEmpty()) {
            resultado = suscripcionService.crearSuscripcionRecursiva(LocalDate.parse(plataformaDTO.getFecha_suscripcion()), p2, u);
            if (!resultado.isExito()) {
                redirectAttributes.addFlashAttribute("error", resultado.getError());
                return resultado.getRedirect();
            }
        }


        usuarioService.save(u);

        return "redirect:/usuarios";
    }

    public String editar(Model model, HttpSession session, RedirectAttributes redirectAttributes, Formulario_PlataformaDTO plataformaDTO, Long id) {
        Plataforma p;
        ValidacionResultado resultado = comprobarSesion(session, id, Objetivo.ACTUALIZAR);

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        if (plataformaDTO == null) {
            p = (Plataforma) resultado.getObjeto();
            model.addAttribute("plataforma", p);
        } else {
            model.addAttribute("plataforma", plataformaDTO);
        }
        model.addAttribute("categorias", Categorias.values());
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
        return "redirect:/usuarios";
    }

    public String eliminar(Long id, HttpSession session, RedirectAttributes redirectAttributes) {
        ValidacionResultado resultado = comprobarSesion(session, id, Objetivo.ELIMINAR);
        Plataforma p;

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        p = (Plataforma) resultado.getObjeto();

        if (!p.isEstado()) {
            redirectAttributes.addFlashAttribute("error", "No se puede eliminar una plataforma que ya está desactivada.");
            return "redirect:/usuarios";
        }

        p.setEstado(false);
        p.getPlanes().forEach(plan -> {
            plan.getSuscripciones().stream().filter(Suscripcion::isActiva).forEach(suscripcion -> {
                suscripcion.setActiva(false);
                suscripcion.setFechaFin(LocalDate.now());
                suscripcionRepository.save(suscripcion);
            });
        });
        save(p);

        redirectAttributes.addFlashAttribute("success", "Plataforma eliminada correctamente.");
        return "redirect:/usuarios";
    }

    public String verDetalle(Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        ValidacionResultado resultado = comprobarSesion(session, id, Objetivo.Detalles);
        Plataforma p;

        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        p = (Plataforma) resultado.getObjeto();

        model.addAttribute("plataforma", toDTO(p));
        session.setAttribute("idPlataforma", p.getId());

        return "plataforma/detalles";
    }

    public String nuevoPlan(Long id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        ValidacionResultado resultado = comprobarSesion(session, id, Objetivo.Detalles);
        if (!resultado.isExito()) {
            redirectAttributes.addFlashAttribute("error", resultado.getError());
            return resultado.getRedirect();
        }

        session.setAttribute("idPlataforma", id);
        return "redirect:/planes/nuevo";
    }

    // EXTRAS:

    private Detalles_PlataformaDTO toDTO(Plataforma p) {
        List<ListarPlanes_PlataformaDTO> planes = p.getPlanes().stream()
                .map(ListarPlanes_PlataformaDTO::toDTO)
                .toList();

        return Detalles_PlataformaDTO.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .planes(planes)
                .build();
    }

    private ValidacionResultado comprobarSesion(HttpSession session, Long idPlataforma, Objetivo objetivo) {
        ValidacionResultado resultado = ExtraMethods.comprobarSesion(session, usuarioService);
        Usuario u;

        if (!resultado.isExito()) {
            return resultado;
        }
        resultado.setExito(false);
        u = (Usuario) resultado.getObjeto();


        if (objetivo == Objetivo.CREAR) {
            resultado.setObjeto(u);
        }

        if (objetivo == Objetivo.ACTUALIZAR || objetivo == Objetivo.ELIMINAR || objetivo == Objetivo.Detalles) {
            resultado = ExtraMethods.comprobarPlataforma(session,idPlataforma, usuarioService, this);

            if (!resultado.isExito()) {
                return resultado;
            }

        }

        resultado.setExito(true);
        return resultado;
    }
}
