package com.salesianostriana.dam.gestionalmacen.Services.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.Listar_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.Nuevo_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.MembresiaRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.SubscripcionRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscripcionService extends BaseServiceImpl<Subscripcion,Long, SubscripcionRepository> {

    private final MembresiaRepository membresiaRepository;
    private final UsuarioRepository usuarioRepository;

    public List<Subscripcion> aplicarFiltros(List<Subscripcion> subscripcions,
                                            String searchTerm,
                                            Double precioMin,
                                            Double precioMax,
                                            Integer almacenesMin,
                                            Boolean soportePrioritario) {
        return subscripcions.stream()
                .filter(s -> (searchTerm == null || s.getNombre().toLowerCase().contains(searchTerm.toLowerCase())))
                .filter(s -> (precioMin == null || s.getPrecio() >= precioMin))
                .filter(s -> (precioMax == null || s.getPrecio() <= precioMax))
                .filter(s -> (almacenesMin == null || s.getNumAlmacenes() >= almacenesMin))
                .filter(s -> (soportePrioritario == null || s.isSoportePrioritario() == soportePrioritario))
                .toList();

    }

    public String listar(Model model, int limit, String searchTerm,
                         Double precioMin,
                         Double precioMax,
                         Integer almacenesMin,
                         Boolean soportePrioritario,
                         Integer paginaActual) {

        List<Subscripcion> subscripciones = findAll();
        List<Subscripcion> subscripcionesFiltradas = aplicarFiltros(subscripciones, searchTerm, precioMin, precioMax, almacenesMin, soportePrioritario);
        List<Subscripcion> subscripcionesPaginadas = subscripcionesFiltradas.reversed().stream()
                .skip((long) (paginaActual - 1) * limit)
                .limit(limit)
                .toList();
        model.addAttribute("subscripciones", subscripcionesPaginadas.stream().map(Listar_SubscripcionDTO::toDTO).toList());

        model.addAttribute("totalSubscripciones", subscripciones.size());
        model.addAttribute("usuariosConSubscripcion", usuarioRepository.findAll().stream().filter(u -> u.getMembresiaActiva() != null).count());
        model.addAttribute("conSoportePrioritario", subscripciones.stream().filter(Subscripcion::isSoportePrioritario).count());

        model.addAttribute("paginaActual", paginaActual);
        model.addAttribute("totalPaginas",calcularTotalPaginas(limit,subscripcionesFiltradas.size()));
        model.addAttribute("tamanoPagina",limit);
        model.addAttribute("totalElementos",subscripcionesPaginadas.size());

        return "Subscripcion/Listar";
    }

    public int calcularTotalPaginas(int itemsPorPagina,int itemsLista) {
        return (int) Math.ceil((double) itemsLista / itemsPorPagina);
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
