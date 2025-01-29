import { Component } from '@angular/core';
import { Author } from '../../models/author';
import { AuthorService } from '../../services/author.service';
import { AuthorComponent } from "../author/author.component";

@Component({
  selector: 'app-authors',
  imports: [AuthorComponent],
  templateUrl: './authors.component.html',
  styleUrl: './authors.component.css'
})
export class AuthorsComponent {

  authors: Array<Author> = [];

  constructor(private authorService: AuthorService) { }

  ngOnInit() {
    this.authorService.findAll().subscribe({
      next: data => this.authors = data,
      error: error => console.error(error),
      complete: () => console.log('Request completed')
    });
  }
}