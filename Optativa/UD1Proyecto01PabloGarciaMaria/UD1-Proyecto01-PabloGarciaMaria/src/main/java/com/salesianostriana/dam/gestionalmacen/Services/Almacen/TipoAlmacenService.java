package com.salesianostriana.dam.gestionalmacen.Services.Almacen;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.TipoAlmacen.Listar_TipoAlmacenDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.DTO.TipoAlmacen.Nuevo_TipoAlmacenDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Enums.CategoriasAlmacen;
import com.salesianostriana.dam.gestionalmacen.Models.Almacen.TipoAlmacen;
import com.salesianostriana.dam.gestionalmacen.Repositories.Almacen.AlmacenRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Almacen.TipoAlmacenRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class TipoAlmacenService extends BaseServiceImpl<TipoAlmacen,Long, TipoAlmacenRepository> {

    private final AlmacenRepository almacenRepository;

    public String listar(Model model) {
        model.addAttribute("tiposAlmacen", repository.findAll().stream().map(Listar_TipoAlmacenDTO::toDTO).toList());
        return "TipoAlmacen/listar";
    }

    public String ver(Model model, Long id, RedirectAttributes redirectAttributes) {

        return repository.findById(id).map(tipoAlmacen -> {
            model.addAttribute("tipoAlmacen", Listar_TipoAlmacenDTO.toDTO(tipoAlmacen));
            return "TipoAlmacen/ver";
        }).orElseGet(() -> {
            redirectAttributes.addFlashAttribute("error", "El tipo de almacén que intentas ver no existe.");
            return "redirect:/almacenes/tipos";
        });
        

    }

    public String nuevo(Model model, Nuevo_TipoAlmacenDTO a) {

        if (a == null) {
            a = new Nuevo_TipoAlmacenDTO();
        }

        model.addAttribute("categorias", CategoriasAlmacen.values());
        model.addAttribute("tipoAlmacen", a);
        model.addAttribute("crear",true);

        return "TipoAlmacen/Formulario";
    }


    public String editar(Model model, Integer id, RedirectAttributes redirectAttributes) {
        return repository.findById(Long.valueOf(id)).map(tipoAlmacen -> {
            model.addAttribute("tipoAlmacen", Nuevo_TipoAlmacenDTO.toDTO(tipoAlmacen));
            model.addAttribute("crear", false);
            return "TipoAlmacen/formulario";
        }).orElseGet(() -> {
            redirectAttributes.addFlashAttribute("error", "El tipo de almacén que intentas editar no existe.");
            return "redirect:/almacenes/tipos";
        });
    }

    public String crear(Model model, Nuevo_TipoAlmacenDTO tipoAlmacenDTO, RedirectAttributes redirectAttributes) {
        TipoAlmacen t = tipoAlmacenDTO.fromDTO(tipoAlmacenDTO);
        t.setId(null);
        save(t);

        redirectAttributes.addFlashAttribute("success", "Tipo de almacén creado correctamente.");

        return "redirect:/almacenes/tipos";
    }

    public String actualizar(Model model, Nuevo_TipoAlmacenDTO tipoAlmacenDTO, RedirectAttributes redirectAttributes) {
        TipoAlmacen t = findById(tipoAlmacenDTO.getId()).orElse(null);
        if (t == null) {
            redirectAttributes.addFlashAttribute("error", "El tipo de almacén con ID " + tipoAlmacenDTO.getId() + " no existe.");
            return "redirect:/almacenes/tipos";
        }

        TipoAlmacen actualizado = t.modify(tipoAlmacenDTO.fromDTO(tipoAlmacenDTO));
        save(actualizado);
        return "redirect:/almacenes/tipos";
    }

    public String eliminar(Model model, Long id, RedirectAttributes redirectAttributes) {

        return findById(id).map(tipoAlmacen -> {
            tipoAlmacen.getAlmacenes().forEach(almacen  -> {
                almacen.setTipoAlmacen(null);
                almacenRepository.save(almacen);
            });
            delete(tipoAlmacen);
            redirectAttributes.addFlashAttribute("success", "Tipo de almacén eliminado correctamente.");
            return "redirect:/almacenes/tipos";
        }).orElseGet(() -> {
            redirectAttributes.addFlashAttribute("error", "El tipo de almacén con ID " + id + " no existe.");
            return "redirect:/almacenes/tipos";
        });
    }
}
