package com.salesianostriana.dam.gestionsuscripciones.Services;

import com.salesianostriana.dam.gestionsuscripciones.Extras.ExtraMethods;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.Extras.ListarPlataformas_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.Extras.ListarSuscripcion_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.Listar_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.DTO.Usuario.Formulario_UsuarioDTO;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Categorias;
import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.ValidacionResultado;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plan;
import com.salesianostriana.dam.gestionsuscripciones.Models.Plataforma;
import com.salesianostriana.dam.gestionsuscripciones.Models.Suscripcion;
import com.salesianostriana.dam.gestionsuscripciones.Models.Usuario;
import com.salesianostriana.dam.gestionsuscripciones.Repositories.UsuarioRepository;
import com.salesianostriana.dam.gestionsuscripciones.Services.Base.BaseServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsuarioService extends BaseServiceImpl<Usuario, Long, UsuarioRepository> {

    private final SuscripcionService suscripcionService;

    public String listar(Model model,HttpSession httpSession) {
        model.addAttribute("usuarios", findAll().stream().map(Listar_UsuarioDTO::toDTO).toList());
        httpSession.setAttribute("id",null);

        return "admin/usuario/listar";
    }

    public String nuevo(Model model, Formulario_UsuarioDTO usuarioDTO) {

        if (usuarioDTO == null) {
            usuarioDTO = new Formulario_UsuarioDTO();
        }

        model.addAttribute("crear", true);
        model.addAttribute("usuario", usuarioDTO);

        return "admin/usuario/formulario";
    }

    public String crear(Formulario_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes, Model model) {

        if (usuarioDTO == null) {
            redirectAttributes.addAttribute("error", "Algo ha fallado durante el envío del formulario.");
            return    "redirect:/usuarios/nuevo";
        }

        Usuario u = usuarioDTO.fromDTO();
        u.setId(null); // Evitamos la modificacion en caso de error desde el front.
        save(u);


        return "redirect:/dashboard";
    }

    public String cambiarEstado(Long id, RedirectAttributes redirectAttributes) {

        Optional<Usuario> u = findById(id);
        if (u.isPresent()) {
            u.get().cambiarEstado();
            save(u.get());
            redirectAttributes.addFlashAttribute("success", "El estado del usuario ha sido modificado correctamente.");
        } else {
            redirectAttributes.addFlashAttribute("error", "No se ha encontrado el usuario solicitado.");
        }

        return "redirect:/dashboard";
    }

    public String editar(Long id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Usuario> u = findById(id);
        if (u.isPresent()) {
            model.addAttribute("usuario", Formulario_UsuarioDTO.toDTO(u.get()));
            model.addAttribute("crear", false);
            return "admin/usuario/formulario";
        } else {
            redirectAttributes.addFlashAttribute("error", "No se ha encontrado el usuario solicitado.");
            return "redirect:/dashboard";
        }
    }

    public String actualizar(Formulario_UsuarioDTO usuarioDTO, RedirectAttributes redirectAttributes, Model model) {
        Optional<Usuario> uOpt = findById(usuarioDTO.getId());
        Usuario uOrg;
        if (uOpt.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return "redirect:/dashboard";
        }
        uOrg = uOpt.get();
        if (usuarioDTO.getPassword() == null || usuarioDTO.getPassword().isEmpty()) {
            usuarioDTO.setPassword(uOrg.getPassword());
        }
        save(uOrg.modify(usuarioDTO.fromDTO()));
        redirectAttributes.addFlashAttribute("success", "Usuario editado correctamente");
        return "redirect:/dashboard";
    }

    public String verDetalle(Model model, RedirectAttributes redirectAttributes, HttpSession httpSession, Long page, Long size, String query) {
        @Builder
        record PaginationInfo(Long number, Long size, int numberOfElements, int totalElements, boolean first, int totalPages, boolean last) {}
        List<ListarPlataformas_UsuarioDTO> plataformas;
        List<ListarSuscripcion_UsuarioDTO> suscripciones;
        List<ListarPlataformas_UsuarioDTO> plataformasLimited;
        List<ListarSuscripcion_UsuarioDTO> suscripcionesLimited;
        long perPage, actualPage;

        if (size == null) {
            perPage = 5L;
        } else {
            perPage = size;
        }

        if (page == null) {
            actualPage = 0L;
        } else {
            actualPage = page;
        }

        Long id = (Long) httpSession.getAttribute("id");

        if (id == null) {
            redirectAttributes.addFlashAttribute("error","Debes iniciar sesión para acceder al dashboard");
            return "redirect:/login";
        }

        Optional<Usuario> uOpt = findById(id);
        Usuario u;
        if (uOpt.isEmpty()){
            redirectAttributes.addFlashAttribute("error","Usuario no encontrado");
            return "redirect:/login";
        }

        suscripcionService.comprobarVencimientos(uOpt.get());

        u = uOpt.get();
        plataformas = u.getPlataformas().stream().filter(p -> {
            if (query == null || query.isEmpty()) {
                return true;
            } else {
                return p.getNombre().toLowerCase().contains(query.toLowerCase());
            }
        }).filter(Plataforma::isEstado).map(ListarPlataformas_UsuarioDTO::toDTO).toList();
        suscripciones =  u.getSuscripciones().stream().filter(Suscripcion::isActiva).map(ListarSuscripcion_UsuarioDTO::toDTO).toList();
        plataformasLimited = plataformas.stream().skip(actualPage*perPage).limit(perPage).toList();
        suscripcionesLimited = suscripciones.stream().skip(actualPage*perPage).limit(perPage).toList();
        model.addAttribute("plataformas", plataformasLimited);
        model.addAttribute("suscripciones", suscripcionesLimited);
        model.addAttribute("avisos", new ArrayList<>());
        model.addAttribute("page", page);

        model.addAttribute("gastoMensual", u.calcularGastoMensual());
        model.addAttribute("gastoAnual", u.calcularGastoAnual());
        model.addAttribute("proximasAVencer", u.suscripcionesProximasAVencer().size());
        int finalPagePlat = Math.round(plataformas.size() / perPage);
        int finalPageSus = Math.round(suscripciones.size() / perPage);
        model.addAttribute("suscripcionPage", new PaginationInfo(actualPage,perPage,suscripcionesLimited.size(),suscripciones.size(),actualPage == 0, finalPageSus, actualPage == finalPageSus)) ;
        model.addAttribute("plataformaPage", new PaginationInfo(actualPage,perPage,plataformasLimited.size(),plataformas.size(),actualPage==0, finalPagePlat, actualPage == finalPagePlat));

        return "usuario/dashboard";
    }

    public ResponseEntity<Map<String,Integer>> verEstadisticasRapidas(Model model, RedirectAttributes redirectAttributes, HttpSession httpSession) {
        ValidacionResultado vr = ExtraMethods.comprobarSesion(httpSession, this);
        Map<String, Integer> conteo = new HashMap<>();
        Long id = (Long) httpSession.getAttribute("id");
        List<Plataforma> plataformas;
        Usuario u;

        if (!vr.isExito()) {
            redirectAttributes.addFlashAttribute("error", vr.getError());
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        u = (Usuario) vr.getObjeto();

        suscripcionService.comprobarVencimientos(u);

        plataformas = u.getPlataformas();
        
        for (Plataforma p : plataformas) {
            if (conteo.containsKey(p.getCategoria().name())) {
                conteo.put(p.getCategoria().name(), conteo.get(p.getCategoria().name()) + 1);
            } else {
                conteo.put(p.getCategoria().name(), 1);
            }
        }

        return ResponseEntity.ok(conteo);

    }
}
