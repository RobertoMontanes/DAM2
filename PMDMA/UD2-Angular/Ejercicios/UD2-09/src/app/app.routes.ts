import { Routes } from '@angular/router';
import { RegisterFormPage } from './Pages/register-form-page/register-form-page';

export const routes: Routes = [
    {path: '',redirectTo: 'register', pathMatch: 'full' },
    {path: 'register', component: RegisterFormPage}
];
