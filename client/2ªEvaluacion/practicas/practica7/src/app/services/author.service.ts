import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Author } from '../models/author';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {

  url: string = 'http://localhost:8081/authors';

  constructor(private httpClient: HttpClient) { }


  findAll(): Observable<Array<Author>> {
    return this.httpClient.get<Array<Author>>(this.url);
  }

  findById(id: number): Observable<Author> {
    return this.httpClient.get<Author>(`${this.url}/${id}`);
  }

  create(author: Author) {
    return this.httpClient.post(this.url, author);
  }

  update(author: Author) {
    return this.httpClient.put(`${this.url}/${author.id}`, author);
  }

  delete(id: number) {
    return this.httpClient.delete(`${this.url}/${id}`);
  }
}