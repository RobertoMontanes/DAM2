package com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum CategoriaProducto {
    ELECTRONICA,
    ROPA,
    ALIMENTACION,
    HOGAR,
    DEPORTE,
    JUGUETES,
    OTROS;

    public static boolean findByString(String categoria) {
        for (CategoriaProducto c : CategoriaProducto.values()) {
            if (c.name().equalsIgnoreCase(categoria)) {
                return true;
            }
        }
        return false;
    }

    public static Map<Integer, String> getCategorias() {
        List<CategoriaProducto> categorias = List.of(CategoriaProducto.values());
        Map<Integer,String> mapaCategorias = new HashMap<>();
        for (int i = 0; i < categorias.size(); i++) {
            mapaCategorias.put(i,categorias.get(i).name());
        }
        return mapaCategorias;
    }
}
