import { Routes } from '@angular/router';
import { HomePage } from './pages/home-page/home-page';
import { AuthPage } from './pages/auth-page/auth-page';
import { PersonalListsPage } from './pages/personal-lists-page/personal-lists-page';

export const routes: Routes = [
    {path: 'moviedb/auth', component: AuthPage},
    {path: 'personalLists', component: PersonalListsPage},
    {path: '', component: HomePage},
    {path: '**', redirectTo: '' }
];
