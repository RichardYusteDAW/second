import { Component } from '@angular/core';
import { Trabajador } from '../../models/trabajador';
import { TRABAJADORES } from '../../../../public/data/data';
import { TrabajadorComponent } from "../trabajador/trabajador.component";

@Component({
  selector: 'app-trabajadores',
  imports: [TrabajadorComponent],
  templateUrl: './trabajadores.component.html',
  styleUrl: './trabajadores.component.css'
})
export class TrabajadoresComponent {
  title: string = 'Listado de trabajadores';
  trabajadores: Array<Trabajador> = TRABAJADORES

  likeTrabajador($event: number) {
    const trabajador = this.trabajadores.find(t => t.id === $event);
    if (trabajador) trabajador.votos++;
  }

  unlikeTrabajador($event: number) {
    const trabajador = this.trabajadores.find(t => t.id === $event);
    if (trabajador) trabajador.votos--;
    if (trabajador!.votos < 0) trabajador!.votos = 0;
  }

  borrarTrabajador($event: number) {
    this.trabajadores = this.trabajadores.filter(t => t.id !== $event);
  }
}