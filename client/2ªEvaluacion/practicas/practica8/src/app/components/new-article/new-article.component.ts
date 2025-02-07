import { Component } from '@angular/core';
import { Article } from '../../models/article';
import { FormsModule } from '@angular/forms';
import { ArticleService } from '../../service/article.service';
import { Router, RouterLink } from '@angular/router';


@Component({
  selector: 'app-new-article',
  imports: [FormsModule, RouterLink],
  templateUrl: './new-article.component.html',
  styleUrl: './new-article.component.css'
})
export class NewArticleComponent {

  article: Article = { id: "", name: '', description: '', units: 0, price: 0 };

  constructor(private articleService: ArticleService, private router: Router) { }

  createArticle() {
    this.articleService.create(this.article).subscribe({
      next: data => this.article = data,
      error: error => console.error('Error creating article', error)
    });

    this.router.navigate(['/articles']);
  }
}