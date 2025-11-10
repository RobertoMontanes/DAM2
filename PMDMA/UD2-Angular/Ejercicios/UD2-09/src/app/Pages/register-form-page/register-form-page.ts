import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-register-form-page',
  imports: [ReactiveFormsModule],
  templateUrl: './register-form-page.html',
  styleUrl: './register-form-page.css',
})
export class RegisterFormPage {

  registerFormGroup = new FormGroup({
    nombreFormControl: new FormControl(''),
    apellidosFormControl: new FormControl(''),
    nifFormControl: new FormControl(''),
    emailFormControl: new FormControl(''),
    telefonoFormControl: new FormControl(''),
    sexoFormControl: new FormControl(''),
    origenFormControl: new FormControl(''),
    passwordFormControl: new FormControl(''),
    confirmarPasswordFormControl: new FormControl(''),
  });

  onSubmit() {
    console.log(this.registerFormGroup.value);
  }

  clearForm() {
    this.registerFormGroup.reset();
  }

}
