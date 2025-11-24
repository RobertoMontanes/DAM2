import { Routes } from '@angular/router';
import { HomePageComponent } from './pages/home-page-component/home-page-component';
import { MovieDetailsPage } from './pages/movie-details-page/movie-details-page';

export const routes: Routes = [
    {
        path: "home",
        component: HomePageComponent
    },
    {
        path: "movies/:id",
        component: MovieDetailsPage
    },
    {
        path: "**",
        redirectTo: "/home"
    }
];
