import { Component } from '@angular/core';
import { Article } from '../../models/article';
import { Router } from '@angular/router';
import { ArticleService } from '../../service/article.service';

@Component({
  selector: 'app-articles',
  imports: [],
  templateUrl: './articles.component.html',
  styleUrl: './articles.component.css'
})
export class ArticlesComponent {

  articles!: Article[];
  url: string = 'http://localhost:3000/articles';

  constructor(private articleService: ArticleService, private router: Router) { }

  ngOnInit() {
    this.loadArticles();
  }

  loadArticles(): void {
    this.articleService.findAll().subscribe({
      next: data => this.articles = data,
      error: error => console.log(error)
    });
  }

  newArticle(): void {
    this.router.navigate(['/articles/new']);
  }

  showArticle(id: string): void {
    this.router.navigate(['/articles', id]);
  }

  updateArticle(id: string): void {
    this.router.navigate(['/articles/update', id]);
  }

  deleteArticle(id: string): void {
    this.articleService.delete(id).subscribe({
      next: () => this.loadArticles(),
      error: error => console.log(error)
    });
    this.loadArticles();
  }
}