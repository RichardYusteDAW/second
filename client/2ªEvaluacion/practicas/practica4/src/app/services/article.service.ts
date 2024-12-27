import { Injectable } from '@angular/core';
import { ARTICULOS } from '../../../public/data/data';
import { Articulo } from '../models/Articulo';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  articulos: Array<Articulo> = ARTICULOS

  constructor() { }

  getArticulos() {
    return this.articulos;
  }

  getArticulo(id: string) {
    return this.articulos.find(a => a.id === id);
  }

  putArticulo(id: string, articulo: Articulo) {
    this.articulos = this.articulos.map(a => a.id === id ? articulo : a);
  }

  postArticulo(articulo: Articulo) {
    this.articulos.push(articulo);
  }

  deleteArticulo(id: string) {
    this.articulos = this.articulos.filter(a => a.id !== id);
  }
}