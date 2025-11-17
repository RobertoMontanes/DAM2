import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { VehiclesService } from '../../services/vehicles.service';
import { Vehicle } from '../../interfaces/vehicle-list-response-interface';
import { RouterLink } from "@angular/router";

@Component({
  selector: 'app-vehicles-list-page',
  imports: [RouterLink],
  templateUrl: './vehicles-list-page.html',
  styleUrl: './vehicles-list-page.css',
})
export class VehiclesListPage implements OnInit {

  constructor(private vehicleService: VehiclesService) {}

  ngOnInit(): void {
    this.cargarVehiculos()
  }

  vehiculos: Vehicle[] = []

  cargarVehiculos() {
    this.vehicleService.obtenerVehiculos().subscribe(r => {
        this.vehiculos = this.vehiculos.concat(r.results);
        for (let index = 0; index < this.vehiculos.length; index++) {
          const element = this.vehiculos[index];
          element.id = this.getID(element);
          
        }
      }
    )
  }

  getID(vehiculo: Vehicle) {
    let url = vehiculo.url
    let id = Number(url.split('/')[5])
    return id;
  }

}
