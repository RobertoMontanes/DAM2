import { Component, OnInit } from '@angular/core';
import { Vehicle } from '../../interfaces/Vehicle-Response-Interface';
import { HttpClient } from '@angular/common/http';
import { VehiclesService } from '../../services/vehicles.service';

@Component({
  selector: 'app-vehicles-list-page',
  imports: [],
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
        this.vehiculos = this.vehiculos.concat(r.results)
      }
    )
  }

}
