import { Routes } from '@angular/router';
import { PeopleListComponent } from './components/people-list-component/people-list-component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'people',
        pathMatch: 'full',  
    },
    {
        path: 'people',
        component: PeopleListComponent
    },
    {
        path: '**',
        redirectTo: '',
    }
];
