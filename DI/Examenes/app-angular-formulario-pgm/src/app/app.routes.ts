import { Routes } from '@angular/router';
import { StudentListPage } from './pages/student-list-page/student-list-page';
import { StudentNewPage } from './pages/student-new-page/student-new-page';

export const routes: Routes = [
    {
        path: "alumnos", 
        component: StudentListPage
    },
    {
        path: "alumnos/nuevo",
        component: StudentNewPage
    },
    {
        path: "**",
        redirectTo: "alumnos"
    }
];
