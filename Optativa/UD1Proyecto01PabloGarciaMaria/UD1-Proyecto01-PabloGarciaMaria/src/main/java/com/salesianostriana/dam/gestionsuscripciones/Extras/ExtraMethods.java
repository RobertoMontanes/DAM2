package com.salesianostriana.dam.gestionsuscripciones.Extras;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Services.PlataformaService;
import com.salesianostriana.dam.gestionsuscripciones.Services.UsuarioService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

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

    public static ValidacionResultado comprobarPlataforma(HttpSession session, Long idPlataforma, UsuarioService usuarioService, PlataformaService plataformaService) {
        ValidacionResultado resultado = comprobarSesion(session, usuarioService);
        Usuario u;

        if (!resultado.isExito()) {
            return resultado;
        }
        resultado.setExito(false);

        u = (Usuario) resultado.getObjeto();
        if (u.findPlataformaById(idPlataforma)) {
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
}
