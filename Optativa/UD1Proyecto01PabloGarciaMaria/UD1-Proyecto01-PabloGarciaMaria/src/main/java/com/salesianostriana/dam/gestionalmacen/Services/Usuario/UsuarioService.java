package com.salesianostriana.dam.gestionalmacen.Services.Usuario;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Subscripcion.Listar_SubscripcionDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Listar_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.DTO.Usuario.Nuevo_UsuarioDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Membresia;
import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.MembresiaRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.SubscripcionRepository;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Almacen.AlmacenService;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    private final AlmacenService almacenService;
    private final MembresiaRepository membresiaRepository;
    private final SubscripcionRepository subscripcionRepository;

    public List<Usuario> aplicarFiltros(List<Usuario> usuarios,String searchTerm, String membresia, String fechaDesde, String fechaHasta, String estado) {
        if (searchTerm != null && !searchTerm.isEmpty()) {
            usuarios = usuarios.stream().filter(u -> u.getNombre().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    u.getApellidos().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    u.getEmail().toLowerCase().contains(searchTerm.toLowerCase())).toList();
        }

        if (membresia != null && !membresia.isEmpty()) {
            if (membresia.equals("con-subscripcion")) {
                usuarios = usuarios.stream().filter(u -> u.getMembresiaActiva() != null).toList();
            } else {
                usuarios = usuarios.stream().filter( u -> u.getMembresiaActiva() != null && u.getMembresiaActiva().getSubscripcion().getId() == Long.parseLong(membresia)).toList();
            }
        }

        if (fechaDesde != null && !fechaDesde.isEmpty()) {
            LocalDate desde = LocalDate.parse(fechaDesde);
            usuarios = usuarios.stream().filter(u -> u.getFechaCreacion().isAfter(desde) || u.getFechaCreacion().isEqual(desde)).toList();
        }

        if (fechaHasta != null && !fechaHasta.isEmpty()) {
            LocalDate hasta = LocalDate.parse(fechaHasta);
            usuarios = usuarios.stream().filter(u -> u.getFechaCreacion().isBefore(hasta) || u.getFechaCreacion().isEqual(hasta)).toList();
        }

        if (estado != null && !estado.isEmpty()) {
            if (estado.equals("activo")) {
                usuarios = usuarios.stream().filter(Usuario::isActivo).toList();
            } else if (estado.equals("inactivo")) {
                usuarios = usuarios.stream().filter(u -> !u.isActivo()).toList();
            }
        }

        return usuarios;
    }

    public Model prepararListar(Model model) {
        List<Usuario> allUsers = findAll();

        model.addAttribute("totalUsuarios", allUsers.size());
        model.addAttribute("usuariosActivos", allUsers.stream().filter(Usuario::isActivo).toList().size());
        model.addAttribute("usuariosConMembresia", allUsers.stream().map(Usuario::getMembresiaActiva).filter(Membresia::nonNull).toList().size());
        model.addAttribute("nuevosEsteMes",allUsers.stream().filter(u -> u.getFechaCreacion().isAfter(LocalDate.now().minusMonths(1))).toList().size());
        model.addAttribute("usuariosTotal",allUsers.size());
        model.addAttribute("subscripciones", subscripcionRepository.findAll().stream().map(Listar_SubscripcionDTO::toDTO).toList());

        return model;
    }

    public String listar(Model model, String searchTerm, String membresia, String fechaDesde, String fechaHasta, String estado) {
        Long limit = 10L, page = 0L;
        List<Usuario> allUsers = findAll();

        model = prepararListar(model);
        model.addAttribute("usuarios", obtenerUsuarios(limit, page, searchTerm, membresia, fechaDesde, fechaHasta,estado, allUsers));
        model.addAttribute("usuariosTotal",aplicarFiltros(allUsers,searchTerm,membresia,fechaDesde,fechaHasta,estado).size());
        return "Usuario/Listar";
    }

    public int getTotalPages(Long limit, String searchTerm, String membresia, String fechaDesde, String fechaHasta, String estado) {
        long totalUsuarios = aplicarFiltros(findAll(),searchTerm,membresia,fechaDesde,fechaHasta,estado).size();
        return (int) Math.ceil((double) totalUsuarios / limit);
    }

    public List<Listar_UsuarioDTO> obtenerUsuarios(Long limit, Long page, String searchTerm, String membresia, String fechaDesde, String fechaHasta,String estado, List<Usuario> usuarios) {
        if (limit == null) {
            limit = 10L;
        }

        if (page == null) {
            page = 0L;
        }

        if (usuarios == null) {
            usuarios = findAll();
        }

        return  aplicarFiltros(usuarios,searchTerm,membresia,fechaDesde,fechaHasta, estado)
                .stream()
                .skip(page * limit)
                .limit(limit)
                .map(Listar_UsuarioDTO::toDTO)
                .toList();

    }

    public String nuevo(Model model, Nuevo_UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) {
            usuarioDTO = new Nuevo_UsuarioDTO();
        }
        model.addAttribute("usuario", usuarioDTO);
        model.addAttribute("crear", true);
        return "Usuario/Formulario";
    }

    public String crear(Model model, Nuevo_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes) {
        Usuario u = usuarioDTO.fromDTO();
        save(u);
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/usuarios";
    }

    public String actualizar(Model model, Nuevo_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes) {
        Optional<Usuario> uOpt = findById(usuarioDTO.getId());
        Usuario uOrg;
        if (uOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return "redirect:/usuarios";
        }
        uOrg = uOpt.get();
        if (usuarioDTO.getPassword().isEmpty()) {
            usuarioDTO.setPassword(uOrg.getPassword());
        }
        save(uOrg.modify(usuarioDTO.fromDTO()));
        redirectAttributes.addFlashAttribute("success", "Usuario editado correctamente");
        return "redirect:/usuarios";
    }

    public String eliminar(Model model, Long id, RedirectAttributes redirectAttributes) {
        Usuario u = findById(id).orElse(null);
        if (u == null) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return "redirect:/usuarios";
        }
        for (Almacen almacen : u.getAlmacenesAsignados()) {
            almacen.setUsuario(null);
            almacenService.save(almacen);
        }

        for (var m : membresiaRepository.findByUsuario(u)) {
            m.setUsuario(null);
            membresiaRepository.save(m);
        }


        delete(u);
        redirectAttributes.addFlashAttribute("success", "Usuario eliminado correctamente");
        return "redirect:/usuarios";
    }

    public String editar(Model model, Integer id) {
        Usuario u = findById(Long.valueOf(id)).orElseThrow();
        model.addAttribute("usuario", Nuevo_UsuarioDTO.toDTO(u));
        model.addAttribute("crear", false);
        return "Usuario/Formulario";
    }

    public String ver(Model model, Long id, RedirectAttributes redirectAttributes) {
        Usuario u = findById(id).orElse(null);
        if (u == null){
            redirectAttributes.addFlashAttribute("error","Usuario no encontrado");
            return "redirect:/usuarios";
        }
        model.addAttribute("usuario", Listar_UsuarioDTO.toDTO(u));
        return "Usuario/Detalles";
    }
}
