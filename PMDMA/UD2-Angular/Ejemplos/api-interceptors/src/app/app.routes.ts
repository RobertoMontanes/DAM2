import { Routes } from '@angular/router';
import { SelectGenrePage } from './pages/select-genre-page/select-genre-page';

export const routes: Routes = [
    {
        path: "genres",
        component: SelectGenrePage
    }, 
    {
        path: "**",
        redirectTo: "genres"
    }
];
