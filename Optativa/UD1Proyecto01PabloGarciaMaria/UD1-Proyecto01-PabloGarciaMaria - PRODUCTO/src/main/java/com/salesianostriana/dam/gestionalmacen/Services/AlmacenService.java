package com.salesianostriana.dam.gestionalmacen.Services;

import com.salesianostriana.dam.gestionalmacen.Models.Almacen.Almacen;
import com.salesianostriana.dam.gestionalmacen.Repositories.Almacen.AlmacenRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AlmacenService extends BaseServiceImpl<Almacen,Long, AlmacenRepository> {
}
