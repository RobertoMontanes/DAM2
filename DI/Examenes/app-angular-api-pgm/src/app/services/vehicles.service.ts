import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { VehiclesResponse } from '../interfaces/vehicle-list-response-interface';
import { VehicleDetail } from '../interfaces/vehicle-details-response-interface';
@Injectable({
  providedIn: 'root',
})
export class VehiclesService {

  constructor(private http: HttpClient) {}

  obtenerVehiculos() {
    return this.http.get<VehiclesResponse>('https://swapi.dev/api/vehicles/')
  }

  obtenerDetalles(id:number) {
    return this.http.get<VehicleDetail>('https://swapi.dev/api/vehicles/'+String(id)+'/')
  }
  
}
