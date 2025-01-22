import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ARTICULOS } from '../../../public/data/data';
import { Articulo } from '../models/articulo';

@Injectable({
  providedIn: 'root'
})
export class ArticuloService {

  articulos: Array<Articulo> = ARTICULOS;
  contador = new BehaviorSubject<number>(this.articulos.length);
  contador$ = this.contador.asObservable();

  getAll() {
    this.contador.next(this.contador.value);
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
    this.contador.next(this.contador.value + 1);
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
    this.contador.next(this.contador.value - 1);
  }
}