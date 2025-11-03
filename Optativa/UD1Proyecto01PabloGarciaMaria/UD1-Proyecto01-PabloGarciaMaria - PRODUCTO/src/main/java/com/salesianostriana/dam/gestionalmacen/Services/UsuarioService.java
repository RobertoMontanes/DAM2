package com.salesianostriana.dam.gestionalmacen.Services;

import com.salesianostriana.dam.gestionalmacen.Models.Usuario.Usuario;
import com.salesianostriana.dam.gestionalmacen.Repositories.Usuario.UsuarioRepository;
import com.salesianostriana.dam.gestionalmacen.Services.Base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseServiceImpl<Usuario,Long, UsuarioRepository> {
}
