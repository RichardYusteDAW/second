import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Article } from '../models/article';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  url: string = 'http://localhost:3000/articles';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Article[]> {
    return this.http.get<Article[]>(this.url);
  }

  findById(id: string): Observable<Article> {
    return this.http.get<Article>(`${this.url}/${id}`);
  }

  create(article: Article): Observable<Article> {
    return this.http.post<Article>(this.url, article);
  }

  update(article: Article): Observable<Article> {
    return this.http.put<Article>(`${this.url}/${article.id}`, article);
  }

  delete(id: string): Observable<Article> {
    return this.http.delete<Article>(`${this.url}/${id}`);
  }
}