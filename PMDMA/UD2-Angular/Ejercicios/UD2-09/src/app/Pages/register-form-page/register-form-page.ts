import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-form-page',
  imports: [ReactiveFormsModule],
  templateUrl: './register-form-page.html',
  styleUrl: './register-form-page.css',
})
export class RegisterFormPage {

  registerFormGroup = new FormGroup({
    nombreFormControl: new FormControl('', [Validators.required, Validators.minLength(3)]),
    apellidosFormControl: new FormControl('', [Validators.required, Validators.minLength(3)]),
    nifFormControl: new FormControl('', [Validators.required, Validators.pattern(/^\d{8}[A-Z]$/)]),
    emailFormControl: new FormControl('', [Validators.required, Validators.email]),
    telefonoFormControl: new FormControl('', [Validators.required, Validators.pattern(/^\d{9}$/)]),
    sexoFormControl: new FormControl('', Validators.required),
    origenFormControl: new FormControl('', Validators.required),
    passwordFormControl: new FormControl('', [Validators.required, Validators.minLength(6)]),
    confirmarPasswordFormControl: new FormControl('', Validators.required),
  });

  onSubmit() {
    console.log(this.registerFormGroup.value);
  }

  clearForm() {
    this.registerFormGroup.reset();
  }

}
