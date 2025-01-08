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
  categorias = new Set<string>();
  articulos: Array<Articulo> = ARTICULOS;
  articulo!: Articulo;

  ngOnInit() {
    this.categorias.add('Todas');
    ARTICULOS.forEach(a => this.categorias.add(a.categoria));
  }

  showArticles(event: Event) {

    const target = event.target as HTMLButtonElement;
    if (target.value == 'Todas') {
      this.articulos = ARTICULOS;
    } else {
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