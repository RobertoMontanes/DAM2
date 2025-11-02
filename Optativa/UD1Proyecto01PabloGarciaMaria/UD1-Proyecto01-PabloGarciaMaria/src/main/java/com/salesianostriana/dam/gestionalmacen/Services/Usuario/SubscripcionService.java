package com.salesianostriana.dam.gestionalmacen.Services.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.Nuevo_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.SubscripcionRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
public class SubscripcionService extends BaseServiceImpl<Subscripcion,Long, SubscripcionRepository> {

    public String listar(Model model) {
        return "Subscripcion/Listar";
    }

    public String ver(Model model, Long id, RedirectAttributes redirectAttributes) {
        return "Subscripcion/Detalles";
    }

    public String nuevo(Model model, Object o) {
        return "Subscripcion/Formulario";
    }

    public String editar(Model model, Integer id) {
        return "Subscripcion/Formulario";
    }

    public String crear(Model model, Nuevo_SubscripcionDTO subscripcionDTO, RedirectAttributes redirectAttributes) {
        return "redirect:/subscripciones";
    }

    public String actualizar(Model model, Nuevo_SubscripcionDTO subscripcionDTO, RedirectAttributes redirectAttributes) {
        return "redirect:/subscripciones";
    }

    public String eliminar(Model model, Long id, RedirectAttributes redirectAttributes) {
        return "redirect:/subscripciones";
    }
    
}
