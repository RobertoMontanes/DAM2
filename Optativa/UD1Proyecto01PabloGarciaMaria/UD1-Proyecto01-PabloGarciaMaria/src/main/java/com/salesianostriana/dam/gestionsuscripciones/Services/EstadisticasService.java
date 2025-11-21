package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.*;
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

import javax.management.openmbean.TabularDataSupport;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstadisticasService {

    private final UsuarioService usuarioService;

    private Double calcularTotalSuscripciones(List<Suscripcion> lista) {
        return lista.stream().mapToDouble(s -> s.getPlan().getPrecio()).sum();
    }

    private Double calcularPorcentajeTotal(int pSize, List<Plataforma> pList) {
        List<Suscripcion> sList = pList.stream()
                .map(Plataforma::getPlanes)
                .flatMap(List::stream)
                .map(Plan::getSuscripciones)
                .flatMap(List::stream).toList();

        return sList.isEmpty() ? 0 : (double) ((pSize * 100) / sList.size());
    }

    private Double calcularVariacion(Double valorInicial, Double valorFinal) {
        return 100 * (valorFinal - valorInicial) / valorInicial;
    }

    private Map<String,Double> CalcularTotalPorPlataforma(List<Plataforma> plataformas) {
        Map<String,Double> plataformasMap = new HashMap<>();
        for (Plataforma p : plataformas) {
            Double totalGasto = calcularTotalSuscripciones(p.getPlanes().stream().map(Plan::getSuscripciones).flatMap(List::stream).toList());
            plataformasMap.put(p.getNombre(), totalGasto);
        }
        return plataformasMap;
    }

    private Long filtrarSuscripcionesPorRenovacion(List<Plataforma> pList) {
        return pList.stream()
                .map(Plataforma::getPlanes)
                .flatMap(List::stream)
                .map(Plan::getSuscripciones)
                .flatMap(List::stream)
                .filter(Suscripcion::isActiva)
                .filter(Suscripcion::isRenovacionAutomatica)
                .count();
    }

    private FiltradoSuscripciones filtrarSuscripciones(String nombreCategoria, List<Suscripcion> suscripciones, String  idPlataforma, int diasPeriodo) {
        List<Suscripcion> suscripcionesFiltradas, suscripcionesFiltradasAnteriores;
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
                    .filter(Suscripcion::isActiva)
                    .toList();
        }
        return new FiltradoSuscripciones(suscripcionesFiltradas, suscripcionesFiltradasAnteriores);
    }

    private List<EstadisticasPlataformaDTO> generarListaEstadisticas(List<Plataforma> plataformas) {
        List<EstadisticasPlataformaDTO> estadisticasPlataformas = new ArrayList<>();
        List<Suscripcion> allUserSubs;
        for (Plataforma p : plataformas) {
            allUserSubs = p.getPlanes().stream().map(Plan::getSuscripciones).flatMap(List::stream).toList();

            EstadisticasPlataformaDTO ep = new EstadisticasPlataformaDTO();

            ep.setNombre(p.getNombre());
            ep.setGastoTotal(calcularTotalSuscripciones(allUserSubs));
            ep.setTotalSuscripciones(allUserSubs.size());
            ep.setGastoPromedio(ep.getGastoTotal() / ep.getTotalSuscripciones());
            ep.setPorcentajeTotal(calcularPorcentajeTotal(ep.getTotalSuscripciones(), plataformas));
            ep.setColor(ExtraMethods.generateRandomColor());

            estadisticasPlataformas.add(ep);
        }
        return estadisticasPlataformas;
    }

    private Map<String, Double> prepararGraficoUltimosMeses(List<Suscripcion> suscripciones) {
        Map<String, Double> grafico12Meses = new LinkedHashMap<>();
        for (int i = 11; i >= 0; i--) {
            LocalDate start = LocalDate.now().minusMonths(i).withDayOfMonth(1);
            String actualMonthName = start.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

            grafico12Meses.put(actualMonthName, (double) 0);

            double totalMes = suscripciones.stream()
                    .filter(s -> s.getFechaInicio().getMonth().equals(start.getMonth())
                            && s.getFechaInicio().getYear() == start.getYear())
                    .mapToDouble(s -> s.getPlan().getPrecio())
                    .sum();

            grafico12Meses.put(actualMonthName, totalMes);
        }
        return grafico12Meses;
    }

    public String cargarEstadisticas(Model model, RedirectAttributes redirectAttributes, HttpSession session, int diasPeriodo, String nombreCategoria, String idPlataforma) throws JsonProcessingException {
        record ListarPlataformasDTO(Long id, String nombre){}
        ValidacionResultado vr = ExtraMethods.comprobarSesion(session, usuarioService);
        FiltradoSuscripciones fs;
        ParCategoriaMasCara categoriaCara;
        Map<String,Integer> categoriasDataMap ;
        Map<String,Double> renovacionesMap , plataformasMap, ultimos12Meses;
        List<Double> categoriasDataProc = new ArrayList<>();
        List<String> coloresCategorias = new ArrayList<>();
        List<Plataforma> totalPlataformasAnterior;
        double gastoTotal, gastoTotalAnterior, gastoPromedio, gastoPromedioAnterior, variacionGastoTotal, totalPlataformas;
        Usuario usuario;
        ObjectMapper mapper = new ObjectMapper();
        String insightAlertas, insightTendencia, periodoStr;
        int suscripcionesProximas;

        if (!vr.isExito()) {
            redirectAttributes.addFlashAttribute("error", vr.getError());
            return "redirect:/login";
        }
        usuario = (Usuario) vr.getObjeto();

        if (usuario.getSuscripciones() == null || usuario.getSuscripciones().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "No puedes ver las estadisticas si no dispones de suscripciones.");
            return "redirect:/dashboard";
        }

        periodoStr = switch (diasPeriodo) {
            case 30 -> "Últimos 30 dias";
            case 90 -> "Últimos 3 meses";
            case 180 -> "Últimos 6 meses";
            case 365 -> "Último año";
            case 999 -> "Todo el historial";
            default -> "Personalizado";
        };

        fs = this.filtrarSuscripciones(nombreCategoria,usuario.getSuscripciones(), idPlataforma, diasPeriodo);


        gastoTotal = calcularTotalSuscripciones(fs.getSuscripcionesFiltradas());
        gastoTotalAnterior = calcularTotalSuscripciones(fs.getSuscripcionesFiltradasAnteriores());
        variacionGastoTotal = calcularVariacion(gastoTotalAnterior, gastoTotal);
        gastoPromedio = fs.getSuscripcionesFiltradas().isEmpty() ? 0 : gastoTotal / fs.getSuscripcionesFiltradas().size();
        gastoPromedioAnterior = gastoTotalAnterior / fs.getSuscripcionesFiltradasAnteriores().size();
        totalPlataformasAnterior = fs.getSuscripcionesFiltradasAnteriores().stream().map(s -> s.getPlan().getPlataforma()).distinct().toList();

        renovacionesMap = calcularTasaRenovacion(usuario.getPlataformas());
        categoriasDataMap = contarPlataformasPorCategoria(usuario.getPlataformas());

        categoriaCara = encontrarCategoriaMasCara(usuario.getPlataformas());

        for (Integer i : categoriasDataMap.values()) {
            int max = usuario.getPlataformas().size();
            categoriasDataProc.add((double) ((i * 100) /max));
        }

        for (Categorias cat : Categorias.values()){
            coloresCategorias.add(CategoriasColores.valueOf(cat.name()).getColorHex());
        }

        suscripcionesProximas = contarSuscripcionesCaducando(usuario.getSuscripciones());

        if (variacionGastoTotal > 10) {
            insightTendencia = "Tu gasto ha aumentado un " + Math.ceil(variacionGastoTotal) + "% respecto al período anterior - considera revisar tus suscripciones";
        } else if (variacionGastoTotal < -5) {
            insightTendencia = "¡Excelente! Has reducido tus gastos en " + Math.ceil(variacionGastoTotal) + "% este período";
        } else {
            insightTendencia = "Mantienes un gasto estable en tus suscripciones - buena gestión financiera";
        }

        if (suscripcionesProximas <= 0) {
            insightAlertas = "Todas tus suscripciones están al día - sin vencimientos próximos";
        } else {
            insightAlertas = suscripcionesProximas + " suscripciones vencen en los próximos 7 días - planifica las renovaciones";
        }

        totalPlataformas = usuario.getPlataformas().size();

        // 40 Lineas de models.
        model.addAttribute("categorias", Categorias.values());
        model.addAttribute("plataformas", usuario.getPlataformas().stream()
                .filter(Plataforma::isEstado)
                .map(p -> new ListarPlataformasDTO(p.getId(), p.getNombre())).
                toList());

        model.addAttribute("periodoActual", periodoStr);

        model.addAttribute("gastoTotal", gastoTotal);
        model.addAttribute("variacionGastoTotal",variacionGastoTotal);
        model.addAttribute("gastoTotalAnterior", gastoTotalAnterior);

        model.addAttribute("totalSuscripciones", fs.getSuscripcionesFiltradas().size()); // 14?
        model.addAttribute("totalSuscripcionesAnterior", fs.getSuscripcionesFiltradasAnteriores().size());
        model.addAttribute("variacionSuscripciones", fs.getSuscripcionesFiltradas().size() - fs.getSuscripcionesFiltradasAnteriores().size());

        model.addAttribute("gastoPromedio", gastoPromedio);
        model.addAttribute("gastoPromedioAnterior", gastoPromedioAnterior);
        model.addAttribute("variacionGastoPromedio", calcularVariacion(gastoPromedioAnterior,gastoPromedio));

        model.addAttribute("totalPlataformas", totalPlataformas);
        model.addAttribute("totalPlataformasAnterior", totalPlataformasAnterior.size());
        model.addAttribute("nuevasPlataformas", totalPlataformas - totalPlataformasAnterior.size());

        ultimos12Meses = this.prepararGraficoUltimosMeses(usuario.getSuscripciones());
        model.addAttribute("mesesLabels",mapper.writeValueAsString(ultimos12Meses.keySet()));
        model.addAttribute("gastosMensualesData",mapper.writeValueAsString(ultimos12Meses.values()));

        model.addAttribute("categoriasLabels",mapper.writeValueAsString(Categorias.values()));
        model.addAttribute("categoriasData",mapper.writeValueAsString(categoriasDataProc));
        model.addAttribute("categoriasColores", mapper.writeValueAsString(coloresCategorias));

        plataformasMap = CalcularTotalPorPlataforma(usuario.getPlataformas());
        model.addAttribute("plataformasLabels",mapper.writeValueAsString(plataformasMap.keySet()));
        model.addAttribute("plataformasData",mapper.writeValueAsString(plataformasMap.values()));

        model.addAttribute("renovacionesLabels", mapper.writeValueAsString(renovacionesMap.keySet()));
        model.addAttribute("renovacionesData", mapper.writeValueAsString(renovacionesMap.values()));

        model.addAttribute("insightTendencia", insightTendencia);
        model.addAttribute("insightAlertas", insightAlertas);

        model.addAttribute("estadisticasPlataformas", generarListaEstadisticas(usuario.getPlataformas()));
        model.addAttribute("suscripcionesConAutoRenovacion",filtrarSuscripcionesPorRenovacion(usuario.getPlataformas()));

        model.addAttribute("categoriaMasCara", categoriaCara.getNombre());

        model.addAttribute("gastoCategoriaMasCara", categoriaCara.getPrecio());

        return "estadisticas/estadisticas";
    }

    private ParCategoriaMasCara encontrarCategoriaMasCara(List<Plataforma> plataformas) {
        Map<String,Double> categoriaCara = new HashMap<>();
        ParCategoriaMasCara parReturn = new ParCategoriaMasCara("", (double) 0);

        for (Plataforma p : plataformas) {
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


        for (Map.Entry<String,Double> entry : categoriaCara.entrySet()) {
            if (parReturn.getNombre().isEmpty()) {
                parReturn.setNombre(entry.getKey());;
                parReturn.setPrecio(entry.getValue());
            } else {
                if (entry.getValue() > parReturn.getPrecio()) {
                    parReturn.setPrecio(entry.getValue());
                    parReturn.setNombre(entry.getKey());
                }
            }
        }
        return parReturn;

    }

    private Map<String, Integer> contarPlataformasPorCategoria(List<Plataforma> plataformas) {
        HashMap<String, Integer> categoriasDataMap = new HashMap<>();
        for (Plataforma p :  plataformas) {
            if (categoriasDataMap.containsKey(p.getCategoria().name())) {
                categoriasDataMap.put(p.getCategoria().name(), categoriasDataMap.get(p.getCategoria().name()) + 1);
            } else {
                categoriasDataMap.put(p.getCategoria().name(), 1);
            }
        }
        return categoriasDataMap;
    }

    private Map<String, Double> calcularTasaRenovacion(List<Plataforma> listPlataforma) {
        Map<String, Double> renovacionesMap = new HashMap<>();
        for (Plataforma p : listPlataforma) {
            int renovacion = 0, cont = 0;
            List<Suscripcion> suscripcionesTrab = p.getPlanes().stream().map(Plan::getSuscripciones).flatMap(List::stream).toList();

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

        return renovacionesMap;
    }

    private int contarSuscripcionesCaducando(List<Suscripcion> listS) {
        int suscripcionesProximas = 0;
        for (Suscripcion s : listS) {
            if (s.isActiva()) {
                if (s.getFechaFin().isBefore(LocalDate.now().plusDays(7))){
                    suscripcionesProximas++;
                }
            }
        }
        return suscripcionesProximas;
    }
}
