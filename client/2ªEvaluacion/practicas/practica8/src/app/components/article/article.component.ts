import { Component } from '@angular/core';
import { Article } from '../../models/article';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article',
  imports: [],
  templateUrl: './article.component.html',
  styleUrl: './article.component.css'
})
export class ArticleComponent {

  article!: Article;
  url: string = 'http://localhost:3000/articles';
  id!: string;

  constructor(private http: HttpClient, private route: ActivatedRoute) {
    this.route.params.subscribe(params => this.id = params['id']);
  }

  ngOnInit() {
    this.loadArticle();
  }

  loadArticle() {
    this.http.get(`${this.url}/${this.id}`).subscribe({
      next: (data: any) => this.article = data,
      error: error => console.log(error)
    });
  }

}