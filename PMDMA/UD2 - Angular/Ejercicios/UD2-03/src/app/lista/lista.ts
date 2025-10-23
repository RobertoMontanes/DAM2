import { Component } from '@angular/core';

  type Alumno = {
    ID: number,
    Nombre : string,
    Apellidos : string,
    Edad: number,
    Curso: string,
    Sexo: boolean,
  }

@Component({
  selector: 'app-lista',
  imports: [],
  templateUrl: './lista.html',
  styleUrl: './lista.css',
})

export class Lista {

  alumnos: Alumno[] = [
    { ID: 0, Nombre: "Pablo", Apellidos: "Garcia Maria", Edad: 19, Curso: "2DAM", Sexo: true },
    { ID: 1, Nombre: "María", Apellidos: "López Ruiz", Edad: 20, Curso: "2DAM", Sexo: false },
    { ID: 2, Nombre: "Antonio", Apellidos: "Martín Pérez", Edad: 18, Curso: "1DAM", Sexo: true },
  ];
  


}
