import { Component } from '@angular/core';
import { ArticuloService } from '../../services/articulo.service';
import { Articulo } from '../../models/articulo';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-articulos',
  imports: [RouterLink],
  templateUrl: './articulos.component.html',
  styleUrl: './articulos.component.css'
})
export class ArticulosComponent {

  articulos!: Array<Articulo>;

  constructor(private articuloService: ArticuloService, private router: Router) { }

  ngOnInit() {
    this.articulos = this.articuloService.getAll();
  }

  verDetalles(id: string) {
    this.router.navigate(['/articulos', id]);
  }
}