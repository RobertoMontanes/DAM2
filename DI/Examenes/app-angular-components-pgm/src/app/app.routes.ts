import { Routes } from '@angular/router';
import { StudentListPage } from './pages/student-list-page/student-list-page';

export const routes: Routes = [
    {
        path: "alumnos", 
        component: StudentListPage
    },
    {
        path: "**",
        redirectTo: "alumnos"
    }
];
