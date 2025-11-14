import { Component } from '@angular/core';
import {FormGroup, FormControl, ReactiveFormsModule, Validators} from '@angular/forms';

@Component({
  selector: 'app-student-new-page',
  imports: [ReactiveFormsModule],
  templateUrl: './student-new-page.html',
  styleUrl: './student-new-page.css',
})
export class StudentNewPage {

  minLengthNAlum = 2;

  nuevoAlumnoFormGroup = new FormGroup({
      nAlumFormControl: new FormControl('',[Validators.required, Validators.min(this.minLengthNAlum)]),
      nombreFormControl: new FormControl('',[Validators.required, Validators.minLength(1)]),
      apellidosFormControl: new FormControl('',[Validators.required, Validators.minLength(1)]),
      nifFormControl: new FormControl('',[Validators.required, Validators.maxLength(8), Validators.minLength(8)]),
      cursoFormControl: new FormControl('',[Validators.required, Validators.minLength(1)]),
  });

  onSubmit(){
    console.log(this.nuevoAlumnoFormGroup.value);
    alert("Alumno creado. (Revisa la consola)")
  }

}
