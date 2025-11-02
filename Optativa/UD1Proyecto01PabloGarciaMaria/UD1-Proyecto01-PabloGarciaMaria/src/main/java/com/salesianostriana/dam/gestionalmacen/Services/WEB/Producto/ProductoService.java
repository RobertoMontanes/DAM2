package com.salesianostriana.dam.gestionalmacen.Services.WEB.Producto;

import ch.qos.logback.core.model.Model;
import com.salesianostriana.dam.gestionalmacen.Models.Producto.Producto;
import com.salesianostriana.dam.gestionalmacen.Repositories.Producto.ProductoRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductoService extends BaseServiceImpl<Producto,Long, ProductoRepository> {

    public String listar(Model model) {
        return "template/producto";
    }
}
