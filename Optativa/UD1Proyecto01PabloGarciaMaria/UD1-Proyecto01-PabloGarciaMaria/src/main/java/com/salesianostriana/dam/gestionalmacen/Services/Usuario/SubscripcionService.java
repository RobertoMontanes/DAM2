package com.salesianostriana.dam.gestionalmacen.Services.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.Listar_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.Nuevo_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.MembresiaRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.SubscripcionRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class SubscripcionService extends BaseServiceImpl<Subscripcion,Long, SubscripcionRepository> {

    private final MembresiaRepository membresiaRepository;

    public String listar(Model model) {
        model.addAttribute("subscripciones", findAll().stream().map(Listar_SubscripcionDTO::toDTO).toList());
        return "Subscripcion/Listar";
    }

    public String ver(Model model, Long id, RedirectAttributes redirectAttributes) {
        Listar_SubscripcionDTO subscripcion = findById(id).map(Listar_SubscripcionDTO::toDTO).orElse(null);
        if (subscripcion == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/subscripciones";
        }
        model.addAttribute("subscripcion", subscripcion);

        return "Subscripcion/Detalles";
    }

    public String nuevo(Model model, Nuevo_SubscripcionDTO subscripcionDTO) {

        if (subscripcionDTO == null) {
            subscripcionDTO = new Nuevo_SubscripcionDTO();
        }

        model.addAttribute("subscripcion", subscripcionDTO);
        model.addAttribute("crear",true);

        return "Subscripcion/Formulario";
    }

    public String crear(Model model, Nuevo_SubscripcionDTO subscripcionDTO, RedirectAttributes redirectAttributes) {

        Subscripcion s = subscripcionDTO.fromDTO();
        s.setId(null);
        save(s);

        redirectAttributes.addFlashAttribute("success", "Subscripción creada correctamente.");

        return "redirect:/subscripciones";
    }

    public String editar(Model model, Integer id, RedirectAttributes redirectAttributes) {
        Subscripcion s = findById(Long.valueOf(id)).orElse(null);
        if (s == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/subscripciones";
        }

        model.addAttribute("subscripcion",Nuevo_SubscripcionDTO.toDTO(s));
        model.addAttribute("crear",false);

        return "Subscripcion/Formulario";
    }


    public String actualizar(Model model, Nuevo_SubscripcionDTO subscripcionDTO, RedirectAttributes redirectAttributes) {

        Subscripcion s = findById(subscripcionDTO.getId()).orElse(null);
        if (s == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + subscripcionDTO.getId() + " no existe.");
            return "redirect:/subscripciones";
        }

        Subscripcion actualizado = s.modify(subscripcionDTO.fromDTO());
        save(actualizado);

        return "redirect:/subscripciones";
    }

    public String eliminar(Model model, Long id, RedirectAttributes redirectAttributes) {

        Subscripcion s = findById(id).orElse(null);

        if (s == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/subscripciones";
        }

        s.getHistorialUsuarios().forEach(historialUsuario -> {
            historialUsuario.setSubscripcion(null);
            membresiaRepository.save(historialUsuario);
        });

        delete(s);
        redirectAttributes.addFlashAttribute("success", "Subscripción eliminada correctamente.");
        return "redirect:/subscripciones";
    }

}
