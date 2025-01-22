import { Routes } from '@angular/router';
import { ArticulosComponent } from './components/articulos/articulos.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { VerarticuloComponent } from './components/verarticulo/verarticulo.component';
import { ErrorComponent } from './components/error/error.component';

export const routes: Routes = [
    { path: '', component: InicioComponent },
    { path: 'articulos', component: ArticulosComponent },
    { path: 'articulos/:id', component: VerarticuloComponent },
    { path: 'error', component: ErrorComponent }
];