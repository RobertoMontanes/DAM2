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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.BindParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstadisticasService {

    private final UsuarioService usuarioService;

    // Angel, no me mates pls
    public String cargarEstadisticas(Model model, RedirectAttributes redirectAttributes, HttpSession session, int diasPeriodo, String nombreCategoria, String idPlataforma) {
        ValidacionResultado vr = ExtraMethods.comprobarSesion(session, usuarioService);
        Usuario usuario;
        List<Suscripcion> suscripciones, suscripcionesFiltradas, suscripcionesFiltradasAnteriores;
        List<Plataforma> totalPlataformas;
        String periodoStr;
        double gastoTotal, gastoTotalAnterior, gastoPromedio, gastoPromedioAnterior;
        int variacionSuscripciones;

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

        if (suscripciones.size() <= 0) {
            redirectAttributes.addFlashAttribute("error", "No tienes suscripciones registradas aún. Añade alguna para ver estadísticas.");
            return "redirect:/dashboard";
        }

        if (nombreCategoria != null && !nombreCategoria.equals("all")) {
            suscripcionesFiltradas = suscripciones.stream()
                    .filter(s -> s.getPlan().getPlataforma().getCategoria().name().equals(nombreCategoria))
                    .toList();
        } else {
            suscripcionesFiltradas = suscripciones.stream()
                    .toList();
        }

        if (!idPlataforma.equals("all")) {
            suscripcionesFiltradas = suscripcionesFiltradas.stream()
                    .filter(s -> s.getPlan().getPlataforma().getId().toString().equals(idPlataforma))
                    .toList();
        }
        suscripcionesFiltradasAnteriores = suscripcionesFiltradas;

        if (diasPeriodo != 999) {
            suscripcionesFiltradasAnteriores = suscripcionesFiltradas.stream()
                    .filter(s -> s.getFechaInicio().isBefore(LocalDate.now().minusDays(diasPeriodo)))
                    .filter(s -> s.getFechaInicio().isAfter(LocalDate.now().minusDays(diasPeriodo* 2L)))
                    .toList();
            suscripcionesFiltradas = suscripcionesFiltradas.stream()
                    .filter(s -> s.getFechaInicio().isAfter(LocalDate.now().minusDays(diasPeriodo)))
                    .toList();

            System.out.println(suscripcionesFiltradasAnteriores);
            System.out.println(suscripcionesFiltradas);
        }

        record ListarPlataformasDTO(Long id, String nombre){};

        model.addAttribute("categorias", Categorias.values());
        model.addAttribute("plataformas", usuario.getPlataformas().stream()
                .filter(Plataforma::isEstado)
                .map(p -> new ListarPlataformasDTO(p.getId(), p.getNombre())).
                toList());

        model.addAttribute("periodoActual", periodoStr);

        gastoTotal = suscripcionesFiltradas.stream()
                .mapToDouble(s -> s.getPlan().getPrecio()).sum();
        model.addAttribute("gastoTotal", gastoTotal);

        gastoTotalAnterior = suscripcionesFiltradasAnteriores.stream()
                .mapToDouble(s -> s.getPlan().getPrecio()).sum();
        model.addAttribute("variacionGastoTotal",calcularVariacion(gastoTotalAnterior, gastoTotal));

        model.addAttribute("totalSuscripciones", suscripcionesFiltradas.size());
        model.addAttribute("variacionSuscripciones", suscripcionesFiltradas.size() - suscripcionesFiltradasAnteriores.size());


        gastoPromedio = gastoTotal / suscripcionesFiltradas.size();
        gastoPromedioAnterior = gastoTotalAnterior / suscripcionesFiltradasAnteriores.size();
        model.addAttribute("gastoPromedio", gastoPromedio);
        model.addAttribute("variacionGastoPromedio", calcularVariacion(gastoPromedioAnterior,gastoPromedio));
        totalPlataformas = suscripcionesFiltradas.stream().map(s -> s.getPlan().getPlataforma()).distinct().toList();
        model.addAttribute("totalPlataformas", totalPlataformas.size());
        model.addAttribute("nuevasPlataformas", suscripcionesFiltradasAnteriores.stream()
                        .map(s -> s.getPlan().getPlataforma())
                        .distinct()
                        .filter(p -> !totalPlataformas.contains(p))
                        .toList()
                        .size()
                );


        return "estadisticas/estadisticas";
    }

    private Double calcularVariacion(Double valorInicial, Double valorFinal) {
        return 100 * (valorFinal - valorInicial) / valorInicial;
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
