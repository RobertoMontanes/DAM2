import { Component, OnInit } from '@angular/core';
import { ListadoProvinciaResponse, Provincia } from '../../interfaces/listado-provincia-response';
import { ProvinciasService } from '../../services/provincias-service';

@Component({
  selector: 'app-list-content-page',
  imports: [],
  templateUrl: './list-content-page.html',
  styleUrl: './list-content-page.css',
})
export class ListContentPage implements OnInit {

  provincias: Provincia[] = []

  constructor (private provinciaService: ProvinciasService) {}

  ngOnInit(): void {
    this.getProvincias()
  }

  getProvincias() {
    this.provinciaService.getListadoProvincias().subscribe(r => {
      this.provincias = r
    });
  }

}
