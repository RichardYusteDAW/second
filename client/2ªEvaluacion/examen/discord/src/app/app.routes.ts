import { Routes } from '@angular/router';
import { TareasComponent } from './components/tareas/tareas.component';
import { InicioComponent } from './components/inicio/inicio.component';
import { ErrorComponent } from './components/error/error.component';
import { PanelComponent } from './components/panel/panel.component';

export const routes: Routes = [
    { path: '', component: InicioComponent },
    { path: 'tareas', component: TareasComponent },
    { path: 'panel', component: PanelComponent },
    { path: '**', component: ErrorComponent }
];