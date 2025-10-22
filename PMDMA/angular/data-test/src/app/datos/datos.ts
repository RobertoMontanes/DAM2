import { Component } from '@angular/core';

@Component({
  selector: 'app-datos',
  imports: [],
  templateUrl: './datos.html',
  styleUrl: './datos.css'
})
export class Datos {


  theme = "Light";
  name = "Pablo"

  getImageURL(pokemon:String) {
    return `https://img.pokemondb.net/sprites/scarlet-violet/normal/${pokemon}.png`
  }

  getEdad(edad:number){
    if (edad >= 18) {
      return "Mayor de edad";
    }
    return "Menor de edad";
  }

  showAlert() {
    alert("HUGO PUTO")
  }

}
