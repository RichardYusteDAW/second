import { Component } from '@angular/core';
import { ARTICULOS } from '../../../../public/data/data';
import { Articulo } from '../../models/Articulo';

@Component({
  selector: 'app-articulos',
  imports: [],
  templateUrl: './articulos.component.html',
  styleUrl: './articulos.component.css'
})
export class ArticulosComponent {
  categorias = new Set<string>(ARTICULOS.map(art => art.categoria));
  articulos: Array<Articulo> = ARTICULOS;
  articulo: Articulo | null = null;

  showArticles(event: Event) {
    this.articulo = null;

    const target = event.target as HTMLButtonElement;
    if (target.value != 'Todas') {
      this.articulos = ARTICULOS.filter(art => art.categoria === target.value);
    }
  }

  verDetalles(art: Articulo) {
    this.articulo = art;
  }

  comprar(art: Articulo) {
    alert(`Has comprado el articulo ${art.nombre}`);
  }
}