import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ListadoProvinciaResponse } from '../interfaces/listado-provincia-response';

@Injectable({
  providedIn: 'root',
})
export class ProvinciasService {

  constructor (private http: HttpClient) {}

  getListadoProvincias(): Observable<ListadoProvinciaResponse> {
    return this.http.get<ListadoProvinciaResponse>("https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/Listados/Provincias/")
  }
  
}
