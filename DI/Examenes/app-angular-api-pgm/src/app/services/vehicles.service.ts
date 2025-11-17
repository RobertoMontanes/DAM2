import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { VehiclesResponse } from '../interfaces/Vehicle-Response-Interface';

@Injectable({
  providedIn: 'root',
})
export class VehiclesService {

  constructor(private http: HttpClient) {}

  obtenerVehiculos() {
    return this.http.get<VehiclesResponse>('https://swapi.dev/api/vehicles/')
  }
  
}
