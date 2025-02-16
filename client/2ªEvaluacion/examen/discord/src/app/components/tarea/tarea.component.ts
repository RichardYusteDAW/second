import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Tarea } from '../../models/tarea';

@Component({
  selector: 'app-tarea',
  imports: [],
  templateUrl: './tarea.component.html',
  styleUrl: './tarea.component.css'
})
export class TareaComponent {

  @Input() tarea!: Tarea;

  @Output() borrar = new EventEmitter<string>();
  borrarTarea(id: string) {
    this.borrar.emit(id);
  }
}