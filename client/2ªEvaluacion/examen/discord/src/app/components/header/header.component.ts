import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Tarea } from '../../models/tarea';
import { TareaService } from '../../services/tarea.service';

@Component({
  selector: 'app-header',
  imports: [RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent { }