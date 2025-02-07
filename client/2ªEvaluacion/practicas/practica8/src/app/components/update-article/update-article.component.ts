import { Component } from '@angular/core';
import { Article } from '../../models/article';
import { ArticleService } from '../../service/article.service';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-update-article',
  imports: [FormsModule, RouterLink],
  templateUrl: './update-article.component.html',
  styleUrl: './update-article.component.css'
})
export class UpdateArticleComponent {

  article: Article = { id: "", name: '', description: '', units: 0, price: 0 };
  constructor(private articleService: ArticleService, private activateRoute: ActivatedRoute, private router: Router) { }


  ngOnInit() {
    this.activateRoute.params.subscribe(params => this.article.id = params['id']);

    this.articleService.findById(this.article.id).subscribe({
      next: data => this.article = data,
      error: error => console.error('Error updating article', error)
    });
  }

  updateArticle() {
    this.articleService.update(this.article).subscribe({
      next: data => this.article = data,
      error: error => console.error('Error updating article', error)
    });

    this.router.navigate(['/articles']);
  }
}