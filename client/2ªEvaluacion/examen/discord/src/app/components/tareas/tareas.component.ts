import { Component } from '@angular/core';
import { Tarea } from '../../models/tarea';
import { TareaService } from '../../services/tarea.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-tareas',
  imports: [FormsModule],
  templateUrl: './tareas.component.html',
  styleUrl: './tareas.component.css'
})
export class TareasComponent {

  tareas: Tarea[] = [];
  tareasFiltradas: Tarea[] = [];
  total: number = 0;
  pendientes: number = 0;
  completadas: number = 0;
  estado: string = 'Todas';


  constructor(private tareaService: TareaService) { }

  ngOnInit() {
    this.cargarTareas();
  }

  cargarTareas() {
    this.tareaService.findAll().subscribe(data => {
      this.tareas = data;
      this.tareasFiltradas = this.tareas;
      this.total = this.tareas.length;
      this.pendientes = this.tareas.filter(t => t.estado == 'Pendiente').length;
      this.completadas = this.tareas.filter(t => t.estado == 'Realizada').length;
    });
  }

  filtrarTareas() {
    if (this.estado == 'Todas') {
      this.tareasFiltradas = this.tareas;
    } else {
      this.tareasFiltradas = this.tareas.filter(t => t.estado == this.estado);
    }
  }

  finalizarTarea(id: string) {
    let tarea = this.tareas.find(t => t.id == id);
    if (tarea) {
      tarea.estado = 'Realizada';
      this.tareaService.update(id, tarea).subscribe(data => this.cargarTareas());
    }
  }
}