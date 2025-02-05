import { Component } from '@angular/core';
import { Article } from '../../models/article';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-articles',
  imports: [],
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent {

  articles!: Array<Article>;
  url: string = 'http://localhost:3000/articles';

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.loadArticles();
  }

  loadArticles() {
    this.http.get(this.url).subscribe({
      next: (data: any) => this.articles = data,
      error: error => console.log(error)
    });
  }
}