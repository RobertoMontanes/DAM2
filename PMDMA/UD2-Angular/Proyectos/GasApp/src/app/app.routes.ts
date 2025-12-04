import { Routes } from '@angular/router';
import { ProvinciasListPage } from './pages/provincias-list-page/provincias-list-page';
import { MunicipiosListPage } from './pages/municipios-list-page/municipios-list-page';
export const routes: Routes = [
    {
        path: 'provincias',
        component: ProvinciasListPage
    },
    {
        path: 'municipios/:id',
        component: MunicipiosListPage
    }
];
