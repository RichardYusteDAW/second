import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarea } from '../models/tarea';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TareaService {

  url: string = 'http://localhost:3000/tareas';
  password: string = '1234';

  constructor(private http: HttpClient) { }

  findAll(): Observable<Tarea[]> {
    return this.http.get<Tarea[]>(this.url);
  }

  findById(id: string): Observable<Tarea> {
    return this.http.get<Tarea>(`${this.url}/${id}`);
  }

  create(tarea: Tarea): Observable<Tarea> {
    return this.http.post<Tarea>(this.url, tarea);
  }

  update(id: string, tarea: Tarea): Observable<Tarea> {
    return this.http.put<Tarea>(`${this.url}/${id}`, tarea);
  }

  delete(id: string): Observable<Tarea> {
    return this.http.delete<Tarea>(`${this.url}/${id}`);
  }

  getPassword(): boolean {
    let pass = prompt('Introduce la contraseña');
    return pass === this.password;
  }
}