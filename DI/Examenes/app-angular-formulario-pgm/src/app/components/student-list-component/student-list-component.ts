import { Component,input } from '@angular/core';
import { Student } from '../../interfaces/Student-interface';

@Component({
  selector: 'app-student-list-component',
  imports: [],
  templateUrl: './student-list-component.html',
  styleUrl: './student-list-component.css',
})
export class StudentListComponent {

  alumno = input<Student>()

  mostrarDetalles() {
    alert(`Se ha pulsado en el alumno ${this.alumno()?.nombre}`)
  }
}
