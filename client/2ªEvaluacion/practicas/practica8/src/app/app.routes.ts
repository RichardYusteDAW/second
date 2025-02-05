import { Routes } from '@angular/router';
import { ArticlesComponent } from './components/articles/articles.component';
import { ArticleComponent } from './components/article/article.component';
import { NewArticleComponent } from './components/new-article/new-article.component';

export const routes: Routes = [
    { path: '', component: ArticlesComponent },
    { path: 'articles', component: ArticlesComponent },
    { path: 'articles/new', component: NewArticleComponent },
    { path: 'article/:id', component: ArticleComponent }
];