import { Routes } from '@angular/router';
import { ArticlesComponent } from './components/articles/articles.component';

export const routes: Routes = [
    { path: '', component: ArticlesComponent },
    { path: 'articles', component: ArticlesComponent },
];