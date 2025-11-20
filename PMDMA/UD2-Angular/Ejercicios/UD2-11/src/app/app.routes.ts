import { Routes } from '@angular/router';
import { MovieDiscoverPage } from './pages/movie-discover-page/movie-discover-page';

export const routes: Routes = [
    {
        path:"discover",
        component: MovieDiscoverPage
    },
    {
        path: '**',
        redirectTo: "discover"
    }
];
