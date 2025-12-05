import { Routes } from '@angular/router';
import { ProvinciasListPage } from './pages/provincias-list-page/provincias-list-page';
import { MunicipiosListPage } from './pages/municipios-list-page/municipios-list-page';
import { GasolinerasListComponent } from './pages/gasolineras-list-component/gasolineras-list-component';
export const routes: Routes = [
    {
        path: 'provincias',
        component: ProvinciasListPage
    },
    {
        path: 'provincias/:id',
        component: MunicipiosListPage
    },
    {
        path: "provincias/:idProvincia/:id",
        component: GasolinerasListComponent
    },
    {
        path: "**",
        redirectTo: "provincias"
    }
];
