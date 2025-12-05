import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MunicipiosListResponse } from '../interfaces/municipios-list-response';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class MunicipioService {
  
  constructor(private http: HttpClient) {}

  getListadoMunicipios(idProvincia: String): Observable<MunicipiosListResponse> {
    return this.http.get<MunicipiosListResponse>(`https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/Listados/MunicipiosPorProvincia/${idProvincia}`);
  }

}
