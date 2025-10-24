import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms'

@Component({
  selector: 'app-perfil',
  imports: [FormsModule],
  templateUrl: './perfil.html',
  styleUrl: './perfil.css',
})
export class Perfil {

  nombre: String = "Pablo"
  apellidos: String = "Garcia Maria"
  email: String = "garcia.mapab24@triana.salesianos.edu"
  edad:number =19


}
