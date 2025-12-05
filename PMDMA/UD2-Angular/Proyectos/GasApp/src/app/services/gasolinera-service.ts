import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Gasolinera, ListadoGasolinerasResponse } from '../interfaces/gasolinera-list-response';

@Injectable({
  providedIn: 'root',
})
export class GasolineraService {

  constructor(private http: HttpClient) { }

  getListadoGasolineras(idProvincia: String): Observable<ListadoGasolinerasResponse> {
    return this.http.get<ListadoGasolinerasResponse>(`https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroProvincia/${idProvincia}`)
  }

  getListadoGasolinerasMunicipio(idMunicipio: String): Observable<ListadoGasolinerasResponse> {
    return this.http.get<ListadoGasolinerasResponse>(`https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/FiltroMunicipio/${idMunicipio}`)
  }

  procesarDatos(datosDefault: ListadoGasolinerasResponse) {
    let gasolineras: Gasolinera[] = [];
      datosDefault.ListaEESSPrecio.forEach(gasolineraUP => {
      let gasolineraP: Gasolinera = new Gasolinera();

      gasolineraP.provinciaID = gasolineraUP.IDProvincia;
      gasolineraP.id = gasolineraUP.IDEESS;
      gasolineraP.rotulo = gasolineraUP["Rótulo"];
      gasolineraP.direccion = gasolineraUP.Dirección;
      gasolineraP.localidad = gasolineraUP.Localidad;
      gasolineraP.municipio = gasolineraUP.Municipio;
      gasolineraP.provincia = gasolineraUP.Provincia;
      gasolineraP.cp = gasolineraUP["C.P."];
      gasolineraP.horario = gasolineraUP.Horario;

      // Conversión de coordenadas
      gasolineraP.coordenadas.latitud = parseFloat(gasolineraUP.Latitud.replace(',', '.'));
      gasolineraP.coordenadas.longitud = parseFloat(gasolineraUP["Longitud (WGS84)"].replace(',', '.'));

      // Conversión de precios
      if (gasolineraUP["Precio Gasoleo A"]) {
        gasolineraP.precios.gasoleoA = parseFloat(gasolineraUP["Precio Gasoleo A"].replace(',', '.'));
      }
      if (gasolineraUP["Precio Gasoleo Premium"]) {
        gasolineraP.precios.gasoleoPremium = parseFloat(gasolineraUP["Precio Gasoleo Premium"].replace(',', '.'));
      }
      if (gasolineraUP["Precio Gasolina 95 E5"]) {
        gasolineraP.precios.gasolina95E5 = parseFloat(gasolineraUP["Precio Gasolina 95 E5"].replace(',', '.'));
      }
      if (gasolineraUP["Precio Gasolina 98 E5"]) {
        gasolineraP.precios.gasolina98E5 = parseFloat(gasolineraUP["Precio Gasolina 98 E5"].replace(',', '.'));
      }

      gasolineras.push(gasolineraP)
    });

    return gasolineras;
  }


}
