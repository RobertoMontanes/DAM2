package com.salesianostriana.dam.gestionalmacen.Services.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.Almacen.Listar_AlmacenDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.Almacen.Nuevo_AlmacenDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Enums.EstadosAlmacen;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.TipoAlmacen;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Almacen.AlmacenRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Almacen.TipoAlmacenRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class AlmacenService extends BaseServiceImpl<Almacen,Long, AlmacenRepository> {

    private final TipoAlmacenRepository tipoAlmacenRepository;
    private final UsuarioRepository usuarioRepository;

    public String listar(Model model) {
        model.addAttribute("almacenes", findAll().stream().map(Listar_AlmacenDTO::toDTO).toList());
        return "Almacen/Listar";
    }

    public String ver(Model model, Long id, RedirectAttributes redirectAttributes) {
        Listar_AlmacenDTO almacen = findById(id).map(Listar_AlmacenDTO::toDTO).orElse(null);
        if (almacen == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/almacenes";
        }
        model.addAttribute("almacen", almacen);

        return "Almacen/Detalles";
    }

    public String nuevo(Model model, Nuevo_AlmacenDTO almacenDTO) {

        if (almacenDTO == null) {
            almacenDTO = new Nuevo_AlmacenDTO();
        }

        model.addAttribute("almacen", almacenDTO);
        model.addAttribute("crear",true);

        return "Almacen/Formulario";
    }

    public String crear(Model model, Nuevo_AlmacenDTO almacenDTO, RedirectAttributes redirectAttributes) throws Exception {

        Almacen s = fromDTO(almacenDTO);
        s.setId(null);
        save(s);

        redirectAttributes.addFlashAttribute("success", "Subscripción creada correctamente.");

        return "redirect:/almacenes";
    }

    public String editar(Model model, Integer id, RedirectAttributes redirectAttributes) {
        Almacen s = findById(Long.valueOf(id)).orElse(null);
        if (s == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/almacenes";
        }

        model.addAttribute("almacen",Nuevo_AlmacenDTO.toDTO(s));
        model.addAttribute("crear",false);

        return "Almacen/Formulario";
    }

    public String actualizar(Model model, Nuevo_AlmacenDTO almacenDTO, RedirectAttributes redirectAttributes) throws Exception {

        Almacen m = findById(almacenDTO.getId()).orElse(null);
        if (m == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + almacenDTO.getId() + " no existe.");
            return "redirect:/almacenes";
        }

        Almacen actualizado = m.modify(fromDTO(almacenDTO));
        save(actualizado);

        return "redirect:/almacenes";
    }

    public String eliminar(Model model, Long id, RedirectAttributes redirectAttributes) {

        Almacen s = findById(id).orElse(null);
        if (s == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/almacenes";
        }
        delete(s);
        redirectAttributes.addFlashAttribute("success", "Subscripción eliminada correctamente.");
        return "redirect:/almacenes";
    }

    private Almacen fromDTO(Nuevo_AlmacenDTO almacenDTO) {

        Usuario u = usuarioRepository.findById(almacenDTO.getUsuarioID())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + almacenDTO.getUsuarioID()));
        TipoAlmacen a = tipoAlmacenRepository.findById(almacenDTO.getTipoAlmacenID())
                .orElseThrow(() -> new IllegalArgumentException("Tipo de Almacén no encontrado con ID: " + almacenDTO.getTipoAlmacenID()));

        return Almacen.builder()
                .id(almacenDTO.getId())
                .nombre(almacenDTO.getNombre())
                .ubicacion(almacenDTO.getUbicacion())
                .superficie(almacenDTO.getSuperficie())
                .estadoAlmacen(EstadosAlmacen.valueOf(almacenDTO.getEstadoAlmacen()))
                .usuario(u)
                .tipoAlmacen(a)
                .seguridad(almacenDTO.isSeguridad())
                .build();
    }




}
