import { Component } from '@angular/core';
import { ARTICULOS } from '../../../../public/data/data';
import { Articulo } from '../../models/Articulo';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-articulos',
  imports: [FormsModule],
  templateUrl: './articulos.component.html',
  styleUrl: './articulos.component.css'
})

export class ArticulosComponent {
  articulos: Array<Articulo> = ARTICULOS;
  articulo: Articulo = this.articulos[0];
  id: string = this.articulo.id;

  comprar(articulo: Articulo) {
    console.log('Comprando:', articulo);
  }

  ver() {
    const art = this.articulos.find(art => art.id === this.id);
    if (art) {
      this.articulo = art;
    } else {
      alert('No existe el articulo');
    }
  }

  modificarUnidades(articulo: Articulo, unidades: number) {
    articulo.unidades += unidades;
    if (articulo.unidades < 0) {
      articulo.unidades = 0;
    }
  }
}