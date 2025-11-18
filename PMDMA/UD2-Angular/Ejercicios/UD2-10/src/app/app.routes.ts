import { Routes } from '@angular/router';
import { PopularMoviesPage } from './pages/movies/popular-movies-page/popular-movies-page';

export const routes: Routes = [
    {
        path: 'movies/popular',
        component: PopularMoviesPage
    }, 
    {
        path: '**',
        redirectTo: 'movies/popular'
    }
];
