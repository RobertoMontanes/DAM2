import { Component } from '@angular/core';
import { StudentListComponent } from "../../components/student-list-component/student-list-component";
import { Student } from '../../interfaces/Student-interface';

@Component({
  selector: 'app-student-list-page',
  imports: [StudentListComponent],
  templateUrl: './student-list-page.html',
  styleUrl: './student-list-page.css',
})
export class StudentListPage {

  alumnos: Student[] = [
    {
      nAlum: 1,
      nombre: 'Juan',
      apellidos: 'García López',
      nif: '12345678A',
      edad: 16,
      cursoMatriculado: '1º DAM'
    },
    {
      nAlum: 2,
      nombre: 'María',
      apellidos: 'Rodríguez Martín',
      nif: '87654321B',
      edad: 17,
      cursoMatriculado: '1º DAM'
    },
    {
      nAlum: 3,
      nombre: 'Carlos',
      apellidos: 'Fernández Pérez',
      nif: '11223344C',
      edad: 16,
      cursoMatriculado: '1º DAM'
    },
    {
      nAlum: 4,
      nombre: 'Ana',
      apellidos: 'Sánchez González',
      nif: '55667788D',
      edad: 17,
      cursoMatriculado: '2º DAM'
    },
    {
      nAlum: 5,
      nombre: 'Pedro',
      apellidos: 'López Moreno',
      nif: '99887766E',
      edad: 16,
      cursoMatriculado: '1º DAM'
    },
    {
      nAlum: 6,
      nombre: 'Laura',
      apellidos: 'Jiménez Torres',
      nif: '44332211F',
      edad: 17,
      cursoMatriculado: '2º DAM'
    },
    {
      nAlum: 7,
      nombre: 'Diego',
      apellidos: 'Ramírez Díaz',
      nif: '22334455G',
      edad: 16,
      cursoMatriculado: '1º DAM'
    },
    {
      nAlum: 8,
      nombre: 'Sofia',
      apellidos: 'Martínez Ruiz',
      nif: '66778899H',
      edad: 17,
      cursoMatriculado: '2º DAM'
    }
  ]

  numAlumnos = this.alumnos.length

}
