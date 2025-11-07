package com.salesianostriana.dam.gestionalmacen.Services.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia.Listar_MembresiaDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Membresia.Nuevo_MembresiaDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.Listar_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Listar_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Subscripcion;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.MembresiaRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembresiaService extends BaseServiceImpl<Membresia, Long, MembresiaRepository> {

    private final UsuarioService usuarioService;
    private final SubscripcionService subscripcionService;

    public String listar(Model model) {
        model.addAttribute("membresias", findAll().stream().map(Listar_MembresiaDTO::toDTO).toList());
        return "Membresia/Listar";
    }

    public String ver(Model model, Long id, RedirectAttributes redirectAttributes) {
        Listar_MembresiaDTO membresia = findById(id).map(Listar_MembresiaDTO::toDTO).orElse(null);
        if (membresia == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/membresias";
        }
        model.addAttribute("membresia", membresia);

        return "Membresia/Detalles";
    }

    public String nuevo(Model model, Nuevo_MembresiaDTO membresiaDTO) {

        System.out.println(membresiaDTO);
        if (membresiaDTO == null) {
            membresiaDTO = new Nuevo_MembresiaDTO();
        }

        model.addAttribute("membresia", membresiaDTO);
        model.addAttribute("subscripciones", subscripcionService.findAll().stream().map(Listar_SubscripcionDTO::toDTO).toList());
        model.addAttribute("usuarios", usuarioService.findAll().stream().map(Listar_UsuarioDTO::toDTO).toList());
        model.addAttribute("crear",true);

        return "Membresia/Formulario";
    }

    public String crear(Model model, Nuevo_MembresiaDTO membresiaDTO, RedirectAttributes redirectAttributes) throws Exception {

        Optional<Usuario> usuarioOptional = usuarioService.findById(membresiaDTO.getUsuarioId());
        Optional<Membresia> membresiaExist;

        if (usuarioOptional.isEmpty()) {
            model.addAttribute("error", "El usuario seleccionado no existe.");
            return nuevo(model, membresiaDTO);
        }

        membresiaExist = repository.findMembresiaByUsuarioNombreAndActivaIsTrue(usuarioOptional.get().getNombre());

        if (membresiaExist.isPresent()) {
            model.addAttribute("error", "El usuario seleccionado ya tiene una membresía activa.");
            return nuevo(model, membresiaDTO);
        }


        Membresia s = fromDTO(membresiaDTO);
        s.setId(null);
        save(s);

        redirectAttributes.addFlashAttribute("success", "Membresia creada correctamente.");

        return "redirect:/membresias";
    }

    public String editar(Model model, Integer id, RedirectAttributes redirectAttributes) {
        Membresia s = findById(Long.valueOf(id)).orElse(null);
        if (s == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/membresias";
        }

        model.addAttribute("membresia",Nuevo_MembresiaDTO.toDTO(s));
        model.addAttribute("subscripciones", subscripcionService.findAll().stream().map(Listar_SubscripcionDTO::toDTO).toList());
        model.addAttribute("usuarios", usuarioService.findAll().stream().map(Listar_UsuarioDTO::toDTO).toList());
        model.addAttribute("crear",false);

        return "Membresia/Formulario";
    }

    public String actualizar(Model model, Nuevo_MembresiaDTO subscripcionDTO, RedirectAttributes redirectAttributes) throws Exception {

        Membresia m = findById(subscripcionDTO.getId()).orElse(null);
        if (m == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + subscripcionDTO.getId() + " no existe.");
            return "redirect:/membresias";
        }

        Membresia actualizado = m.modify(fromDTO(subscripcionDTO));
        save(actualizado);

        return "redirect:/membresias";
    }

    public String eliminar(Model model, Long id, RedirectAttributes redirectAttributes) {

        Membresia s = findById(id).orElse(null);
        if (s == null) {
            redirectAttributes.addFlashAttribute("error", "La subscripción con ID " + id + " no existe.");
            return "redirect:/membresias";
        }
        delete(s);
        redirectAttributes.addFlashAttribute("success", "Subscripción eliminada correctamente.");
        return "redirect:/membresias";
    }

    public Membresia fromDTO(Nuevo_MembresiaDTO membresiaDTO) throws Exception {

        Usuario u = usuarioService.findById(membresiaDTO.getUsuarioId()).orElse(null);

        if (u == null) {
            throw new Exception("No hay usuario en la membresia.");
        }

        Subscripcion s = subscripcionService.findById(membresiaDTO.getSubscripcionId()).orElse(null);

        if (s == null) {
            throw new Exception("No hay subscripcion en la membresia.");
        }
        LocalDate fechaIncio = LocalDate.parse(membresiaDTO.getFechaInicio());
        LocalDate fechaFin = fechaIncio.plusMonths(s.getDuracionMeses());

        return Membresia.builder()
                .id(membresiaDTO.getId())
                .fechaInicio(fechaIncio)
                .activa(membresiaDTO.isActiva())
                .fechaFin(fechaFin)
                .usuario(u)
                .subscripcion(s)
                .cancelado(membresiaDTO.isCancelado())
                .build();
    }
}
