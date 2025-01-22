import { Component } from '@angular/core';
import { Articulo } from '../../models/articulo';
import { FormsModule } from '@angular/forms';
import { ArticuloService } from '../../services/articulo.service';
import { RouterLink, Router } from '@angular/router';

@Component({
  selector: 'app-nuevoarticulo',
  imports: [FormsModule, RouterLink],
  templateUrl: './nuevoarticulo.component.html',
  styleUrl: './nuevoarticulo.component.css'
})
export class NuevoarticuloComponent {

  articulo: Articulo = { id: '', nombre: '', descripcion: '', precio: 0, unidades: 0 };

  constructor(private articuloService: ArticuloService, private router: Router) { }

  create() {
    this.articuloService.create(this.articulo);
    this.router.navigate(['/articulos']);
  }
}