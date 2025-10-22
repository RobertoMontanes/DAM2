import { Component } from '@angular/core';

@Component({
  selector: 'app-title',
  imports: [],
  templateUrl: './title.html',
  styleUrl: './title.css'
})
export class Title { 
  cont:number = 1
  titulos:string[] = [
    "Bienvenido",
    "Gracias por usar el programa",
    "Adios"
  ]
  titulo:string = 'Bienvenido'


  cambiarTitulo() {
    this.titulo = this.titulos[this.cont++ % this.titulos.length]
  }
}
  