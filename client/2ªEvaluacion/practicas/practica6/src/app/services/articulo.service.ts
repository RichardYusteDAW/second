import { Injectable } from '@angular/core';
import { Articulo } from '../models/articulo';
import { ARTICULOS } from '../../../public/data/data';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

  articulos: Array<Articulo> = ARTICULOS;

  getAll() {
    return this.articulos;
  }

  getById(id: string) {
    // Check if article exists
    const art = this.articulos.find(articulo => articulo.id === id);
    if (!art) {
      console.log('Artículo no encontrado');
      return;
    }
    return art;
  }

  create(articulo: Articulo) {
    // Check if article exists
    const art = this.articulos.find(art => art.id === articulo.id);
    if (art) {
      console.log('Artículo ya existe');
      return;
    }
    this.articulos.push(articulo);
  }

  update(articulo: Articulo) {
    // Check if article exists
    const art = this.articulos.find(art => art.id === articulo.id);
    if (!art) {
      console.log('Artículo no encontrado');
      return;
    }
    // Update article
    this.articulos = this.articulos.map(a => a.id === articulo.id ? articulo : a);
  }

  delete(id: string) {
    // Check if article exists
    const art = this.articulos.find(art => art.id === id);
    if (!art) {
      console.log('Artículo no encontrado');
      return;
    }
    // Delete article
    this.articulos = this.articulos.filter(art => art.id !== id);
  }
}