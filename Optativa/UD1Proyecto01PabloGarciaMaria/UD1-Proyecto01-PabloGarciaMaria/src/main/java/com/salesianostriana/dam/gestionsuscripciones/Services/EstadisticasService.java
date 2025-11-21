package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Categorias;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.CategoriasColores;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.EstadisticasPlataformaDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstadisticasService {

    private final UsuarioService usuarioService;

    private Double calcularTotalSuscripciones(List<Suscripcion> lista) {
        return lista.stream().mapToDouble(s -> s.getPlan().getPrecio()).sum();
    }

    private String generateRandomColor() {
        String[] caracteres = {
                "0", "1", "2", "3", "4", "5", "6",  "7", "8", "9", "A", "B", "C", "D", "E", "F"
        };
        String cad = "#";
        int len = 6;
        Random rnd = new Random(System.nanoTime());

        for  (int i = 0; i < len; i++) {
            cad += caracteres[rnd.nextInt(caracteres.length)];
        }
        return cad;
    }

    private Double calcularPorcentajeTotal(int pSize, List<Plataforma> pList) {
        List<Suscripcion> sList = pList.stream()
                .map(Plataforma::getPlanes)
                .flatMap(List::stream)
                .map(Plan::getSuscripciones)
                .flatMap(List::stream).toList();

        return (double) ((pSize * 100) / sList.size());
    }

    private Double calcularVariacion(Double valorInicial, Double valorFinal) {
        return 100 * (valorFinal - valorInicial) / valorInicial;
    }

    // Angel, no me mates pls
    public String cargarEstadisticas(Model model, RedirectAttributes redirectAttributes, HttpSession session, int diasPeriodo, String nombreCategoria, String idPlataforma) throws JsonProcessingException {
        ValidacionResultado vr = ExtraMethods.comprobarSesion(session, usuarioService);
        Map<String,Integer> categoriasDataMap = new HashMap<>();
        Map<String,Double> plataformasMap = new HashMap<>();
        Map<String,Double> renovacionesMap = new HashMap<>();
        List<Suscripcion> suscripciones, suscripcionesFiltradas, suscripcionesFiltradasAnteriores;
        List<Plataforma> totalPlataformasAnterior;
        List<Double> suscripcionesUltimos12Meses= new ArrayList<>();
        List<Double> categoriasDataProc = new ArrayList<>();
        List<String> coloresCategorias = new ArrayList<>();
        List<String> ultimos12Meses = new ArrayList<>();
        List<EstadisticasPlataformaDTO> estadisticasPlataformas = new ArrayList<>();
        Usuario usuario;
        ObjectMapper mapper = new ObjectMapper();
        String insightAlertas, insightTendencia, periodoStr;
        double gastoTotal, gastoTotalAnterior, gastoPromedio, gastoPromedioAnterior, variacionGastoTotal, suscripcionesConAutoRenovacion, totalPlataformas;
        int suscripcionesProximas = 0;
        String categoriaMasCara;
        Double gastoCategoriaMasCara;

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

        if (suscripciones.isEmpty()) {
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
        }

        record ListarPlataformasDTO(Long id, String nombre){}

        gastoTotal = calcularTotalSuscripciones(suscripcionesFiltradas);
        gastoTotalAnterior = calcularTotalSuscripciones(suscripcionesFiltradasAnteriores);
        variacionGastoTotal = calcularVariacion(gastoTotalAnterior, gastoTotal);
        gastoPromedio = gastoTotal / suscripcionesFiltradas.size();
        gastoPromedioAnterior = gastoTotalAnterior / suscripcionesFiltradasAnteriores.size();
        totalPlataformasAnterior = suscripcionesFiltradasAnteriores.stream().map(s -> s.getPlan().getPlataforma()).distinct().toList();


        // GRAFICO GASTOS MESES
        for (int i = 12; i >= 1; i--) {
            LocalDate start = LocalDate.now().minusMonths(i).withDayOfMonth(1);
            LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

            ultimos12Meses.add(start.getMonth().name());

            double totalMes = suscripciones.stream()
                    .filter(s -> !(s.getFechaFin().isBefore(start) || s.getFechaInicio().isAfter(end)))
                    .mapToDouble(s -> s.getPlan().getPrecio())
                    .sum();

            suscripcionesUltimos12Meses.add(totalMes);
        }

        for (Plataforma p : usuario.getPlataformas()) {
            /* Checkear tasa renovacion - Params */
            int renovacion = 0, cont = 0;
            List<Suscripcion> suscripcionesTrab = p.getPlanes().stream().map(Plan::getSuscripciones).flatMap(List::stream).toList();

            /* Total por plataforma */
            Double totalGasto = calcularTotalSuscripciones(p.getPlanes().stream().map(Plan::getSuscripciones).flatMap(List::stream).toList());
            plataformasMap.put(p.getNombre(), totalGasto);

            /* Plataformar por categoria*/
            if (categoriasDataMap.containsKey(p.getCategoria().name())) {
                categoriasDataMap.put(p.getCategoria().name(), categoriasDataMap.get(p.getCategoria().name()) + 1);
            } else {
                categoriasDataMap.put(p.getCategoria().name(), 1);
            }

            /* Checkear tasa renovacion */
            for (int i = 0; i < suscripcionesTrab.size(); i++) {
                Suscripcion sActual = suscripcionesTrab.get(i);
                Suscripcion sSiguiente = i+1 >= suscripcionesTrab.size() ? suscripcionesTrab.get(i) : suscripcionesTrab.get(i+1);


                if (!sActual.equals(sSiguiente)) {
                    if(sActual.getFechaFin().equals(sSiguiente.getFechaInicio())) {
                        renovacion++;
                    }
                    cont++;
                }
            }
            renovacionesMap.put(p.getNombre(),(double) (renovacion * 100) / cont);

        }




        for (Integer i : categoriasDataMap.values()) {
            int max = usuario.getPlataformas().size();
            categoriasDataProc.add((double) ((i * 100) /max));
        }

        for (Categorias cat : Categorias.values()){
            coloresCategorias.add(CategoriasColores.valueOf(cat.name()).getColorHex());
        }

        for (Plataforma p : usuario.getPlataformas()) {

        }

        for (Suscripcion sActual : suscripciones) {
            /* Suscripciones Proximas */
            if (sActual.isActiva()) {
                if (sActual.getFechaFin().isBefore(LocalDate.now().plusDays(7))){
                    suscripcionesProximas++;
                }
            }

        }
        if (variacionGastoTotal > 10) {
            insightTendencia = "Tu gasto ha aumentado un " + Math.abs(variacionGastoTotal) + "% respecto al período anterior - considera revisar tus suscripciones";
        } else if (variacionGastoTotal < -5) {
            insightTendencia = "¡Excelente! Has reducido tus gastos en " + Math.abs(variacionGastoTotal) + "% este período";
        } else {
            insightTendencia = "Mantienes un gasto estable en tus suscripciones - buena gestión financiera";
        }

        if (suscripcionesProximas <= 0) {
            insightAlertas = "Todas tus suscripciones están al día - sin vencimientos próximos";
        } else {
            insightAlertas = suscripcionesProximas + " suscripciones vencen en los próximos 7 días - planifica las renovaciones";
        }


        for (Plataforma p : usuario.getPlataformas()) {
            List<Suscripcion> allUserSubs = p.getPlanes().stream().map(Plan::getSuscripciones).flatMap(List::stream).toList();

            EstadisticasPlataformaDTO ep = new EstadisticasPlataformaDTO();
            ep.setNombre(p.getNombre());
            ep.setGastoTotal(calcularTotalSuscripciones(allUserSubs));
            ep.setTotalSuscripciones(allUserSubs.size());
            ep.setGastoPromedio(ep.getGastoTotal() / ep.getTotalSuscripciones());
            ep.setPorcentajeTotal(calcularPorcentajeTotal(ep.getTotalSuscripciones(), usuario.getPlataformas()));
            ep.setColor(generateRandomColor());
            estadisticasPlataformas.add(ep);
        }

        suscripcionesConAutoRenovacion = usuario.getPlataformas()
                .stream()
                .map(Plataforma::getPlanes)
                .flatMap(List::stream)
                .map(Plan::getSuscripciones)
                .flatMap(List::stream)
                .filter(Suscripcion::isActiva)
                .filter(Suscripcion::isRenovacionAutomatica)
                .count();


        totalPlataformas = usuario.getPlataformas().size();

        Map<String, Double> categoriaCara = new HashMap<>();
        for (Plataforma p : usuario.getPlataformas()) {
            Double precioMensual = p.getPlanes().stream()
                    .map(Plan::getSuscripciones)
                    .flatMap(List::stream)
                    .filter(Suscripcion::isActiva)
                    .map(Suscripcion::getPlan)
                    .mapToDouble(Plan::calcularGastoMensual)
                    .sum();

            if (categoriaCara.containsKey(p.getCategoria().name())) {
                categoriaCara.put(p.getCategoria().name(), categoriaCara.get(p.getCategoria().name()) + precioMensual);
            } else {
                categoriaCara.put(p.getCategoria().name(), precioMensual);
            }
        }

        categoriaMasCara = "";
        gastoCategoriaMasCara = (double) 0;
        for (Map.Entry<String,Double> entry : categoriaCara.entrySet()) {
            if (categoriaMasCara.isEmpty()) {
                categoriaMasCara = entry.getKey();
                gastoCategoriaMasCara = entry.getValue();
            } else {
                if (entry.getValue() > gastoCategoriaMasCara) {
                    gastoCategoriaMasCara = entry.getValue();
                    categoriaMasCara = entry.getKey();
                }
            }
        }

        model.addAttribute("categorias", Categorias.values());
        model.addAttribute("plataformas", usuario.getPlataformas().stream()
                .filter(Plataforma::isEstado)
                .map(p -> new ListarPlataformasDTO(p.getId(), p.getNombre())).
                toList());

        model.addAttribute("periodoActual", periodoStr);

        model.addAttribute("gastoTotal", gastoTotal);
        model.addAttribute("variacionGastoTotal",variacionGastoTotal);
        model.addAttribute("gastoTotalAnterior", gastoTotalAnterior);

        model.addAttribute("totalSuscripciones", suscripcionesFiltradas.size());
        model.addAttribute("totalSuscripcionesAnterior", suscripcionesFiltradasAnteriores.size());
        model.addAttribute("variacionSuscripciones", suscripcionesFiltradas.size() - suscripcionesFiltradasAnteriores.size());

        model.addAttribute("gastoPromedio", gastoPromedio);
        model.addAttribute("gastoPromedioAnterior", gastoPromedioAnterior);
        model.addAttribute("variacionGastoPromedio", calcularVariacion(gastoPromedioAnterior,gastoPromedio));

        model.addAttribute("totalPlataformas", totalPlataformas);
        model.addAttribute("totalPlataformasAnterior", totalPlataformasAnterior.size());
        model.addAttribute("nuevasPlataformas", totalPlataformas - totalPlataformasAnterior.size());

        model.addAttribute("mesesLabels",mapper.writeValueAsString(ultimos12Meses));
        model.addAttribute("gastosMensualesData",mapper.writeValueAsString(suscripcionesUltimos12Meses));

        model.addAttribute("categoriasLabels",mapper.writeValueAsString(Categorias.values()));
        model.addAttribute("categoriasData",mapper.writeValueAsString(categoriasDataProc));
        model.addAttribute("categoriasColores", mapper.writeValueAsString(coloresCategorias));

        model.addAttribute("plataformasLabels",mapper.writeValueAsString(plataformasMap.keySet()));
        model.addAttribute("plataformasData",mapper.writeValueAsString(plataformasMap.values()));

        model.addAttribute("renovacionesLabels", mapper.writeValueAsString(renovacionesMap.keySet()));
        model.addAttribute("renovacionesData", mapper.writeValueAsString(renovacionesMap.values()));

        model.addAttribute("insightTendencia", insightTendencia);
        model.addAttribute("insightAlertas", insightAlertas);

        model.addAttribute("estadisticasPlataformas", estadisticasPlataformas);
        model.addAttribute("suscripcionesConAutoRenovacion",suscripcionesConAutoRenovacion);

        model.addAttribute("categoriaMasCara", categoriaMasCara);

        model.addAttribute("gastoCategoriaMasCara", gastoCategoriaMasCara);

        return "estadisticas/estadisticas";
    }
}
