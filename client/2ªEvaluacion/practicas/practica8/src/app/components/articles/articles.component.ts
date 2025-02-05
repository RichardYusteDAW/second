import { Component } from '@angular/core';
import { Article } from '../../models/article';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-articles',
  imports: [],
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent {

  articles!: Array<Article>;
  url: string = 'http://localhost:3000/articles';

  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    this.loadArticles();
  }

  loadArticles() {
    this.http.get(this.url).subscribe({
      next: (data: any) => this.articles = data,
      error: error => console.log(error)
    });
  }

  newArticle() {
    this.router.navigate(['/articles/new']);
  }

  showArticle(id: string) {
    this.router.navigate(['/article', id]);
  }

  deleteArticle(id: string) {
    this.http.delete(`${this.url}/${id}`).subscribe({
      next: () => console.log('Article deleted'),
      error: error => console.log(error)
    });
    this.loadArticles();
  }
}