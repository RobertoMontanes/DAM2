package com.salesianostriana.dam.gestionsuscripciones.Models;

import com.salesianostriana.dam.gestionsuscripciones.Models.Extras.Estado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidos;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    private Estado estado;

    private LocalDate fechaCreacion;
    private LocalDateTime ultimaConexion;

    @OneToMany
    @ToString.Exclude
    private List<Plataforma> plataformas;

    @OneToMany
    @ToString.Exclude
    private List<Suscripcion> suscripciones;

    public Usuario modify(Usuario usuario) {
        this.nombre = usuario.getNombre();
        this.apellidos = usuario.getApellidos();
        this.email = usuario.getEmail();
        this.password = usuario.getPassword();
        return this;
    }

    public void cambiarEstado() {
        this.estado = this.estado == Estado.ACTIVO ? Estado.INACTIVO : Estado.ACTIVO;
    }

    public void addPlataforma(Plataforma p) {
        if (this.plataformas == null) {
            this.plataformas = new java.util.ArrayList<>();
        }
        this.plataformas.add(p);
    }

    public boolean findPlataformaById(Long id) {
        System.out.println("AQUI");
        for (Plataforma p : plataformas) {
            System.out.println(p);
            if (p.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public boolean isActivo() {
        return this.estado == Estado.ACTIVO;
    }

    public void addSuscripcion(Suscripcion s) {
        if (this.suscripciones == null) {
            this.suscripciones = new java.util.ArrayList<>();
        }
        this.suscripciones.add(s);
    }

    public Double calcularGastoMensual() {
        double total = 0.0;
        LocalDate now = LocalDate.now();
        for (Suscripcion s : suscripciones) {
            if (s.getFechaFin().getMonth() == now.getMonth() && s.getFechaFin().getYear() == now.getYear()) {
                total += s.getPlan().getPrecio();
            }
        }
        return total;
    }

    public Double calcularGastoAnual() {
        double total = 0.0;
        LocalDate now = LocalDate.now();
        for (Suscripcion s : suscripciones) {
            if (s.getFechaFin().getYear() == now.getYear()) {
                total += s.getPlan().getPrecio();
            }
        }
        return total;

    }

    public List<Suscripcion> suscripcionesProximasAVencer() {
        List<Suscripcion> suscripcionesProximas = new ArrayList<>();
        for (Suscripcion s : suscripciones) {
            if (s.isActiva() && s.getFechaFin().isBefore(LocalDate.now().plusDays(7))) {
                suscripcionesProximas.add(s);
            }
        }
        return suscripcionesProximas;
    }
}
