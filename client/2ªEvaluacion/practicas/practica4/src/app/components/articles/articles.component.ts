import { Component } from '@angular/core';
import { ArticleService } from '../../services/article.service';
import { Articulo } from '../../models/Articulo';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-articles',
  imports: [FormsModule],
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent {

  articles: Array<Articulo>;
  article: Articulo;
  newArticle: Articulo;
  isVisible: boolean;
  title: string;

  constructor(private articleService: ArticleService) {
    this.articles = this.articleService.getArticulos();
    this.article = { id: '', nombre: '', descripcion: '', unidades: 0, precio: 0 };
    this.newArticle = { ...this.article };
    this.isVisible = false;
    this.title = "";
  }

  mostarFormulario(article?: Articulo) {
    this.isVisible = true;
    if (article) {
      this.title = "Modificar Articulo";
      this.newArticle = { ...article };
    } else {
      this.title = "Nuevo Articulo";
      this.newArticle = { id: '', nombre: '', descripcion: '', unidades: 0, precio: 0 };
    }
  }

  ocultarFormulario() {
    this.isVisible = false;
  }

  crearArticulo(article: Articulo) {
    // check if article exists
    if (this.articleService.getArticulo(article.id)) {
      this.articleService.putArticulo(article.id, article);
    } else {
      this.articleService.postArticulo(article);
    }
    this.articles = this.articleService.getArticulos();
    this.ocultarFormulario();
  }

  borrarArticulo(id: string) {
    this.articleService.deleteArticulo(id);
    this.articles = this.articleService.getArticulos();
  }
}