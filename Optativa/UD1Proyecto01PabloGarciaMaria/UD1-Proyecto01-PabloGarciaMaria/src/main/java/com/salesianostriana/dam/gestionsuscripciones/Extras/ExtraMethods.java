package com.salesianostriana.dam.gestionsuscripciones.Extras;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Services.PlanService;
import com.salesianostriana.dam.gestionsuscripciones.Services.PlataformaService;
import com.salesianostriana.dam.gestionsuscripciones.Services.SuscripcionService;
import com.salesianostriana.dam.gestionsuscripciones.Services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class ExtraMethods {

    public static ValidacionResultado comprobarSesion(HttpSession session, UsuarioService usuarioService) {
        ValidacionResultado resultado = new ValidacionResultado();
        Long idUsuario = (Long) session.getAttribute("id");
        Optional<Usuario> uOpt;

        if (idUsuario == null) {
            resultado.setError("No puedes trabajar sin antes haber iniciado sesion.");
            resultado.setRedirect("redirect:/login");
            return resultado;
        }

        uOpt = usuarioService.findById(idUsuario);
        if (uOpt.isEmpty()) {
            resultado.setError("Estas intentando trabajar con un usuario inexistente.");
            resultado.setRedirect("redirect:/login");
            return resultado;
        }

        resultado.setObjeto(uOpt.get());
        resultado.setExito(true);
        return resultado;
    }

    public static ValidacionResultado comprobarPlan(HttpSession session, Long idPlataforma, UsuarioService usuarioService, PlataformaService plataformaService, Long idPlan, PlanService planService) {
        ValidacionResultado resultado = comprobarPlataforma(session,idPlataforma,usuarioService,plataformaService);
        Plataforma p;
        Optional<Plan> planOpt;
        List<Plan> pList;
        if (!resultado.isExito()) {
            return resultado;
        }
        resultado.setExito(false);

        planOpt = planService.findById(idPlan);

        if (planOpt.isEmpty()) {
            resultado.setError("No se ha encontrado el plan solicitado.");
            resultado.setRedirect("redirect:/plataformas");
            return resultado;
        }

        p = (Plataforma) resultado.getObjeto();
        pList = p.getPlanes()
                .stream()
                .filter(plan -> plan.getId().equals(idPlan))
                .toList();

        if (pList.isEmpty()) {
            resultado.setError("No puedes trabajar con un plan que no pertenece a la plataforma seleccionada.");
            resultado.setRedirect("redirect:/plataformas");
            return resultado;
        }

        if (!pList.getFirst().getId().equals(idPlan) && !pList.getFirst().getId().equals(planOpt.get().getId()) && !planOpt.get().getId().equals(idPlan)) {
            resultado.setError("Algo ha ido mal al intentar validar el plan seleccionado.");
            resultado.setRedirect("redirect:/plataformas");
            return resultado;
        }

        resultado.setObjeto(planOpt.get());
        resultado.setExito(true);
        return resultado;


    }

    public static ValidacionResultado comprobarPlataforma(HttpSession session, Long idPlataforma, UsuarioService usuarioService, PlataformaService plataformaService) {
        ValidacionResultado resultado = comprobarSesion(session, usuarioService);
        Usuario u;

        if (!resultado.isExito()) {
            return resultado;
        }
        resultado.setExito(false);

        u = (Usuario) resultado.getObjeto();
        if (u.findPlataformaById(idPlataforma)) {
            System.out.println(u.getPlataformas());
            resultado.setError("No puedes trabajar con una plataforma que no te pertenece.");
            resultado.setRedirect("redirect:/usuarios");
            return resultado;
        }

        Optional<Plataforma> pOpt = plataformaService.findById(idPlataforma);
        if (pOpt.isEmpty()) {
            resultado.setError("No se ha encontrado la plataforma solicitada.");
            resultado.setRedirect("redirect:/usuarios");
            return resultado;
        }

        resultado.setObjeto(pOpt.get());
        resultado.setExito(true);
        return resultado;
    }


    public static ValidacionResultado comprobarSuscripcion(HttpSession session, UsuarioService usuarioService, Long id, SuscripcionService suscripcionService) {
        ValidacionResultado resultado = comprobarSesion(session, usuarioService);
        Usuario u;

        if (!resultado.isExito()) {
            return resultado;
        }
        resultado.setExito(false);
        u = (Usuario) resultado.getObjeto();

        if (suscripcionService.findById(id).isEmpty()) {
            resultado.setError("No se ha encontrado la suscripción solicitada.");
            resultado.setRedirect("redirect:/dashboard");
            return resultado;
        }

        if (u.getSuscripciones().stream().noneMatch(s -> s.getId().equals(id))) {
            resultado.setError("No puedes trabajar con una suscripción que no te pertenece.");
            resultado.setRedirect("redirect:/dashboard");
            return resultado;
        }

        resultado.setObjeto(suscripcionService.findById(id).get());
        resultado.setExito(true);
        return resultado;
    }
}
