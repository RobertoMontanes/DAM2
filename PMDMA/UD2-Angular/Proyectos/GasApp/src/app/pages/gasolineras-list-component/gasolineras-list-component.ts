import { Component } from '@angular/core';
import { GasolineraService } from '../../services/gasolinera-service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { Gasolinera, ListadoGasolinerasResponse } from '../../interfaces/gasolinera-list-response';
import { NavbarComponent } from "../../components/shared/navbar-component/navbar-component";

@Component({
  selector: 'app-gasolineras-list-component',
  imports: [NavbarComponent, RouterLink],
  templateUrl: './gasolineras-list-component.html',
  styleUrl: './gasolineras-list-component.css',
})
export class GasolinerasListComponent {

  idMunicipio: string = '';
  idProvincia: string = '';
  datosBase: ListadoGasolinerasResponse = {} as ListadoGasolinerasResponse;
  datosGasolineras: Gasolinera[] = [];

  constructor(private service: GasolineraService, private activatedRoute: ActivatedRoute) {
    this.idMunicipio = this.activatedRoute.snapshot.paramMap.get('id')!;
    this.idProvincia = this.activatedRoute.snapshot.paramMap.get('idProvincia')!;

    this.getListadoGasolineras();
  }

  getListadoGasolineras() {
    this.service.getListadoGasolinerasMunicipio(this.idMunicipio).subscribe(response => {
      this.datosBase = response;
      this.datosGasolineras = this.service.procesarDatos(this.datosBase);      
    });
  }

}
