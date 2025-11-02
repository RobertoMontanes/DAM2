package com.salesianostriana.dam.gestionalmacen.Models.Producto.Enum;

import java.util.HashMap;
import java.util.Map;

public enum Accion {

    INSERTAR,
    RETIRAR;

    public static Map<Integer, String> getAcciones() {
        Map<Integer, String> map = new HashMap<>();
        for (Accion a : Accion.values()) {
            map.put(a.ordinal(), a.name());
        }
        return map;
    }
}
