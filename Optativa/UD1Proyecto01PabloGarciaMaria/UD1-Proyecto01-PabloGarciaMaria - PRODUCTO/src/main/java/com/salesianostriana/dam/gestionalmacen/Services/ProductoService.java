package com.salesianostriana.dam.gestionalmacen.Services;

import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.ListarProducto_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.ListarUsuario_ProductoDTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.DTO.Producto.NuevoProducto_DTO;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum.CategoriaProducto;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Producto;
import com.salesianostriana.dam.gestionalmacen.Repositories.Producto.ProductoRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Service
@RequiredArgsConstructor
public class ProductoService extends BaseServiceImpl<Producto,Long, ProductoRepository> {

    private final AlmacenService almacenService;
    private final UsuarioService usuarioService;

    public String listar(Model model) {

        model.addAttribute("categorias", CategoriaProducto.values());
        model.addAttribute("productos", repository.findAll().stream().map(ListarProducto_DTO::toDTO).toList());

        return "producto/listar";
    }

    public String nuevo(Model model) {

        model.addAttribute("producto", new NuevoProducto_DTO());
        model.addAttribute("categorias", CategoriaProducto.values());
        model.addAttribute("usuarios", usuarioService.findAll().stream().map(ListarUsuario_ProductoDTO::toDTO).toList());

        return  "producto/formulario";
    }

    public String crear(NuevoProducto_DTO productoDTO, RedirectAttributes redirectAttributes) {
        Producto p;
        boolean almacenes = false;

        if (productoDTO.getCantidad() < 0 || productoDTO.getPeso() < 0) {
            redirectAttributes.addFlashAttribute("error", "La cantidad y el peso deben ser valores positivos.");
            return "redirect:/productos/nuevo";
        }

        if (productoDTO.getNombre().isBlank()) {
            redirectAttributes.addFlashAttribute("error", "El nombre del producto no puede estar vacío.");
            return "redirect:/productos/nuevo";
        }

//        if (productoDTO.getAlmacenID() == null) {
//            redirectAttributes.addFlashAttribute("error", "Debe seleccionar un almacén.");
//            return "redirect:/productos/nuevo";
//        }

        if (productoDTO.getUsuarioID() == null) {
            redirectAttributes.addFlashAttribute("error", "Debe seleccionar un usuario.");
            return "redirect:/productos/nuevo";
        }

        p = fromDTO(productoDTO);

        p.setUsuario(usuarioService.findById(productoDTO.getUsuarioID()).orElse(null));

        if (p.getUsuario() == null) {
            redirectAttributes.addFlashAttribute("error", "El usuario seleccionado no existe.");
            return "redirect:/productos/nuevo";
        }

//        p.setAlmacen(almacenService.findById(productoDTO.getAlmacenID()).orElse(null));
//
//        if (p.getAlmacen() == null) {
//            redirectAttributes.addFlashAttribute("error", "El almacén seleccionado no existe.");
//            return "redirect:/productos/nuevo";
//        }

        repository.save(p);

        return "redirect:/productos";
    }

    private Producto fromDTO(NuevoProducto_DTO productoDTO) {
        return Producto.builder()
                .nombre(productoDTO.getNombre())
                .cantidad(productoDTO.getCantidad())
                .peso(productoDTO.getPeso())
                .categoriaProducto(CategoriaProducto.valueOf(productoDTO.getCategoriaProducto()))
                .build();
    }
}
