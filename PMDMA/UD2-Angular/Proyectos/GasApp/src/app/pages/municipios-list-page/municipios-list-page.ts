import { Component } from '@angular/core';
import { NavbarComponent } from "../../components/shared/navbar-component/navbar-component";
import { Municipio } from '../../interfaces/municipios-list-response';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { MunicipioService } from '../../services/municipio-service';
import { UpperCasePipe } from '@angular/common';
import { Provincia } from '../../interfaces/provincias-list-response';

@Component({
  selector: 'app-municipios-list-page',
  imports: [NavbarComponent, RouterLink],
  templateUrl: './municipios-list-page.html',
  styleUrl: './municipios-list-page.css',
})
export class MunicipiosListPage {

  municipios: Municipio[] = [];
  provincia: Provincia = {} as Provincia;

  constructor(private activeRoute: ActivatedRoute, private service: MunicipioService) {
    const idProvincia = this.activeRoute.snapshot.paramMap.get('id');
    this.getListadoMunicipios(idProvincia!);
  }

  getListadoMunicipios(idProvincia: String) {
    this.service.getListadoMunicipios(idProvincia).subscribe(response => {
      this.municipios = response;

      this.provincia = {
        IDProvincia: this.municipios[0].IDProvincia,
        IDPovincia: this.municipios[0].IDProvincia,
        Provincia: this.municipios[0].Provincia,
        CCAA: this.municipios[0].CCAA,
        IDCCAA: this.municipios[0].IDCCAA
      } as Provincia;
    });
  }



}
