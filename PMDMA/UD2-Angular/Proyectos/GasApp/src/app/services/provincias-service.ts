import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProvinciasListResponse, ProvinciaSorted } from '../interfaces/provincias-list-response';

@Injectable({
  providedIn: 'root',
})
export class ProvinciasService {
  sortProvincias(provinciasRaw: ProvinciasListResponse): ProvinciaSorted[] {
    let provinciasSort: ProvinciaSorted[] = []

    provinciasRaw.forEach(provincia => {
      let comunidad = provinciasSort.find(c => c.ComunidadAutonoma === provincia.CCAA);
      if (comunidad) {
        comunidad.Provincias.push(provincia);
      } else {
        let nuevaComunidad: ProvinciaSorted = {
          IDCCAA: provincia.IDCCAA,
          ComunidadAutonoma: provincia.CCAA,
          Provincias: [provincia]
        }
        provinciasSort.push(nuevaComunidad);
      }
    })

    return provinciasSort;
  }

  constructor (private http: HttpClient) {}

  getListadoProvincias(): Observable<ProvinciasListResponse> {
    return this.http.get<ProvinciasListResponse>("https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/Listados/Provincias/")
  }
  
}
