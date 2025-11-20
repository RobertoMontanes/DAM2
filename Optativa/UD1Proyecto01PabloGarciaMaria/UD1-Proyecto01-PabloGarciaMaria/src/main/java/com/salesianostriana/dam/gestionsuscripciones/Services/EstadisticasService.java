package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Categorias;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.BindParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EstadisticasService {

    private final UsuarioService usuarioService;

    // Angel, no me mates pls
    public String cargarEstadisticas(Model model, RedirectAttributes redirectAttributes, HttpSession session, int diasPeriodo, String nombreCategoria, String idPlataforma) {
        ValidacionResultado vr = ExtraMethods.comprobarSesion(session, usuarioService);
        Usuario usuario;
        List<Suscripcion> suscripciones, suscripcionesFiltradas;
        String periodoStr;

        if (!vr.isExito()) {
            redirectAttributes.addFlashAttribute("error", vr.getError());
            return "redirect:/login";
        }
        usuario = (Usuario) vr.getObjeto();

        periodoStr = switch (diasPeriodo) {
            case 30 -> "Últimos 30 dias";
            case 90 -> "Últimos 3 meses";
            case 180 -> "Últimos 6 meses";
            case 365 -> "Último año";
            case 999 -> "Todo el historial";
            default -> "Personalizado";
        };

        suscripciones = usuario.getSuscripciones();
        if (nombreCategoria != null && !nombreCategoria.equals("all")) {
            suscripcionesFiltradas = suscripciones.stream()
                    .filter(Suscripcion::isActiva)
                    .filter(s -> s.getPlan().getPlataforma().getCategoria().name().equals(nombreCategoria))
                    .toList();
        } else {
            suscripcionesFiltradas = suscripciones.stream()
                    .filter(Suscripcion::isActiva)
                    .toList();
        }

        if (!idPlataforma.equals("all")) {
            suscripcionesFiltradas = suscripcionesFiltradas.stream()
                    .filter(s -> s.getPlan().getPlataforma().getId().toString().equals(idPlataforma))
                    .toList();
        }

        if (diasPeriodo != 999) {
            suscripcionesFiltradas = suscripcionesFiltradas.stream()
                    .filter(s -> s.getFechaInicio().isAfter(LocalDate.now().minusDays(diasPeriodo)))
                    .toList();
        }

        record ListarPlataformasDTO(Long id, String nombre){};

        model.addAttribute("categorias", Categorias.values());
        model.addAttribute("plataformas", usuario.getPlataformas().stream()
                .filter(Plataforma::isEstado)
                .map(p -> new ListarPlataformasDTO(p.getId(), p.getNombre())).
                toList());
        model.addAttribute("periodoActual", periodoStr);


        return "estadisticas/estadisticas";
    }

    private Double calcularMensualidad(Plan plan){
        int dias, meses, anios, totalMeses;
        dias = plan.getFrecuencia().getDays() / 30;
        meses = plan.getFrecuencia().getMonths();
        anios = plan.getFrecuencia().getYears() * 12;
        totalMeses = dias + meses + anios;
        return plan.getPrecio() / totalMeses;
    }
}
