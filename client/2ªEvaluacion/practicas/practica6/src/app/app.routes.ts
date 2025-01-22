import { Routes } from '@angular/router';
import { ArticulosComponent } from './components/articulos/articulos.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { VerarticuloComponent } from './components/verarticulo/verarticulo.component';
import { ErrorComponent } from './components/error/error.component';
import { EliminararticuloComponent } from './components/eliminararticulo/eliminararticulo.component';
import { NuevoarticuloComponent } from './components/nuevoarticulo/nuevoarticulo.component';

export const routes: Routes = [
    { path: '', component: InicioComponent },
    { path: 'articulos', component: ArticulosComponent },
    { path: 'nuevoarticulo', component: NuevoarticuloComponent },
    { path: 'articulos/:id', component: VerarticuloComponent },
    { path: 'eliminararticulo/:id', component: EliminararticuloComponent },
    { path: 'error', component: ErrorComponent }
];