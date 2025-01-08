import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Trabajador } from '../../models/trabajador';

@Component({
  selector: 'app-trabajador',
  imports: [],
  templateUrl: './trabajador.component.html',
  styleUrl: './trabajador.component.css'
})
export class TrabajadorComponent {
  @Input() trabajador!: Trabajador;

  // like() {
  //   this.trabajador!.votos++;
  // }

  // unlike() {
  //   this.trabajador!.votos--;
  //   if (this.trabajador!.votos < 0) {
  //     this.trabajador!.votos = 0;
  //   }
  // }

  @Output() sumaVoto = new EventEmitter<number>();
  likeTrabajador(id: number) {
    this.sumaVoto.emit(id);
  }

  @Output() restaVoto = new EventEmitter<number>();
  unlikeTrabajador(id: number) {
    this.restaVoto.emit(id);

  }

  @Output() borrar = new EventEmitter<number>();
  borrarTrabajador(id: number) {
    this.borrar.emit(id);
  }
}