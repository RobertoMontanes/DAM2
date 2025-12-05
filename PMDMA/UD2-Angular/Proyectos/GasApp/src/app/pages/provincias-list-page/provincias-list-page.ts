import { Component, OnInit } from '@angular/core';
import { ProvinciasService } from '../../services/provincias-service';
import { RouterLink } from "@angular/router";
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from "../../components/shared/navbar-component/navbar-component";
import { ComunidadAutonoma, ProvinciaSorted } from '../../interfaces/provincias-list-response';

@Component({
  selector: 'app-provincias-list-page',
  imports: [RouterLink, FormsModule, NavbarComponent],
  templateUrl: './provincias-list-page.html',
  styleUrl: './provincias-list-page.css',
})
export class ProvinciasListPage implements OnInit {
  selectedCCAA: string = '';
  filterProvince: string = '';

  provinciasOrdenadas: ProvinciaSorted[] = []
  comunidadesAutonomas: ComunidadAutonoma[] = []

  constructor(private service: ProvinciasService) {}

  ngOnInit(): void {
    this.getListadoProvincias();
  }

  resetFilters() {
    this.filterProvince = '';
    this.establishCCAA({target: {value: ''}} as unknown as Event);
  } 

  applyFilter() {
    let newProvincias: ProvinciaSorted[] = [];
    
    this.provinciasOrdenadas.forEach(comunidad => {
      let provinciasFiltradas = comunidad.Provincias.filter(provincia => 
        provincia.Provincia.toLowerCase().includes(this.filterProvince.toLowerCase())
      );

      if (provinciasFiltradas.length > 0) {
        newProvincias.push({
          IDCCAA: comunidad.IDCCAA,
          ComunidadAutonoma: comunidad.ComunidadAutonoma,
          Provincias: provinciasFiltradas
        });
      }
    });

    this.provinciasOrdenadas = newProvincias;
  }

  filterCCAA() {
    let newProvincias: ProvinciaSorted[] = [];
    
    this.provinciasOrdenadas.forEach(comunidad => {
      if (comunidad.IDCCAA === this.selectedCCAA) {
        newProvincias.push(comunidad);
      }
    });

    this.provinciasOrdenadas = newProvincias;
  }

  establishCCAA(event: Event) {
    const idCCAA = (event.target as HTMLSelectElement).value;
    this.selectedCCAA = idCCAA;
    this.getListadoProvincias();
  }

  generateComunidadesAutonomas() {
    this.provinciasOrdenadas.forEach(comunidad => {
      this.comunidadesAutonomas.push({
        IDCCAA: comunidad.IDCCAA,
        ComunidadAutonoma: comunidad.ComunidadAutonoma
      });
    });
  }

  getListadoProvincias() {
    this.provinciasOrdenadas = [];
    console.log(this.provinciasOrdenadas);
    this.service.getListadoProvincias().subscribe(r => {
      this.provinciasOrdenadas = this.service.sortProvincias(r);

      if (this.selectedCCAA) {
        this.filterCCAA();
      } else {
        this.generateComunidadesAutonomas();
      }

      if (this.filterProvince) {
        this.applyFilter();
      }

    })
  }

}
