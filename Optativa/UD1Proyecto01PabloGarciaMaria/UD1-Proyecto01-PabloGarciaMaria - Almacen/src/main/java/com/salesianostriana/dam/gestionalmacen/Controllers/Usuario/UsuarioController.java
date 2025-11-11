package com.salesianostriana.dam.gestionalmacen.Controllers.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Listar_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Nuevo_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Services.Usuario.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @GetMapping
    public String listar(Model model,
                         @RequestParam(required = false) String searchTerm,
                         @RequestParam(required = false) String subscripcion,
                         @RequestParam(required = false) String fechaDesde,
                         @RequestParam(required = false) String fechaHasta,
                         @RequestParam(required = false) String estado) {
        return service.listar(model, searchTerm, subscripcion, fechaDesde, fechaHasta, estado);
    }

    @GetMapping("/paginacion/obtener")
    @ResponseBody
    public ResponseEntity<List<Listar_UsuarioDTO>> obtenerUsuarios(Model model, @RequestParam(required = false) Long limit, @RequestParam(required = false) Long page,
                                                                   @RequestParam(required  = false) String searchTerm,
                                                                    @RequestParam(required = false) String subscripcion,
                                                                    @RequestParam(required = false) String fechaDesde,
                                                                    @RequestParam(required = false) String fechaHasta,
                                                                   @RequestParam(required = false) String estado) {
        return ResponseEntity.ok(service.obtenerUsuarios(limit, page, searchTerm, subscripcion, fechaDesde, fechaHasta, estado, null));
    }

    @GetMapping("/paginacion/paginas")
    @ResponseBody
    public ResponseEntity<Integer> getTotalPages(@RequestParam(required = false) Long limit,
                                                 @RequestParam(required  = false) String searchTerm,
                                                 @RequestParam(required = false) String subscripcion,
                                                 @RequestParam(required = false) String fechaDesde,
                                                 @RequestParam(required = false) String fechaHasta,
                                                 @RequestParam(required = false) String estado) {
        return ResponseEntity.ok(service.getTotalPages(limit, searchTerm, subscripcion, fechaDesde, fechaHasta, estado));
    }
    
    @GetMapping("/{id}")
    public String ver(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        return service.ver(model,id,redirectAttributes);
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        return service.nuevo(model,null);
    }

    @GetMapping("/editar/{id}")
    public String editar(Model model, @PathVariable Integer id) {
        return service.editar(model,id);
    }

    @PostMapping
    public String crear(Model model,@ModelAttribute("usuario") Nuevo_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes) {
        return service.crear(model,usuarioDTO,redirectAttributes);
    }

    @PutMapping
    public String actualizar(Model model,@ModelAttribute("usuario") Nuevo_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes) {
        return service.actualizar(model, usuarioDTO, redirectAttributes);
    }

    @DeleteMapping("/{id}")
    public String eliminar(Model model, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        return service.eliminar(model,id,redirectAttributes);
    }


}

