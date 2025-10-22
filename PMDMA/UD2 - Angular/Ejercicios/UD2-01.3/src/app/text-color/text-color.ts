import { Component } from '@angular/core';

@Component({
  selector: 'app-text-color',
  imports: [],
  templateUrl: './text-color.html',
  styleUrl: './text-color.css'
})
export class TextColor {
  colores:string[] = [
    "red",
    "black"
  ]

  colorTexto:string = this.colores[0];

  cambiarColor() {
    if (this.colorTexto == this.colores[0]) {
      this.colorTexto = this.colores[1]
    } else {
      this.colorTexto = this.colores[0]
    }
  }

}
