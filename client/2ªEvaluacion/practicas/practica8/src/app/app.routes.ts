import { Routes } from '@angular/router';
import { ArticlesComponent } from './components/articles/articles.component';
import { ArticleComponent } from './components/article/article.component';
import { NewArticleComponent } from './components/new-article/new-article.component';
import { UpdateArticleComponent } from './components/update-article/update-article.component';

export const routes: Routes = [
    { path: '', component: ArticlesComponent },
    { path: 'articles', component: ArticlesComponent },
    { path: 'articles/new', component: NewArticleComponent },
    { path: 'articles/update/:id', component: UpdateArticleComponent },
    { path: 'articles/:id', component: ArticleComponent }
];