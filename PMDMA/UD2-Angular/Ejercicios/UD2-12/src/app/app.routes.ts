import { Routes } from '@angular/router';
import { MovieDiscoverPage } from './pages/movie-discover-page/movie-discover-page';
import { MovieListPage } from './pages/movie-list-page/movie-list-page';
import { MovieDetailsPage } from './pages/movie-details-page/movie-details-page';
import { PeopleListPage } from './pages/people-list-page/people-list-page';
import { PeopleDetailsPage } from './pages/people-details-page/people-details-page';

export const routes: Routes = [
    {
        path:"discover",
        component: MovieDiscoverPage
    },
    {
        path: "movies",
        component: MovieListPage
    },
    {
        path: "movies/:id",
        component: MovieDetailsPage
    },
    {
        path: "people",
        component: PeopleListPage
    },
    {
        path: "people/:id",
        component: PeopleDetailsPage
    },
    {
        path: '**',
        redirectTo: "discover"
    }
];
