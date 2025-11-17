package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Suscripcion.Nuevo_SuscripcionDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.SuscripcionRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class SuscripcionService extends BaseServiceImpl<Suscripcion, Long, SuscripcionRepository> {

    private final UsuarioService usuarioService;

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

        return "suscripciones/formulario";
    }

    public String crear(Model model, HttpSession session, RedirectAttributes redirectAttributes, Nuevo_SuscripcionDTO suscripcionDTO) {
        return "despues lo hago";
    }
}
