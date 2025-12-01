import { Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home-page';
import { AuthPage } from './pages/auth-page/auth-page';
import { PersonalListsPage } from './pages/personal-lists-page/personal-lists-page';
import { ListDetailsPage } from './pages/list-details-page/list-details-page';

export const routes: Routes = [
    {path: 'moviedb/auth', component: AuthPage},
    {path: 'lists', component: PersonalListsPage},
    {path: 'lists/:id', component: ListDetailsPage},
    {path: '', component: HomePage},
    {path: '**', redirectTo: '' }
];
