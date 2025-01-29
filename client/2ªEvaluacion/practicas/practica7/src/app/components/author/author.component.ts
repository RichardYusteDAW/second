import { Component, Input } from '@angular/core';
import { Author } from '../../models/author';
import { AuthorService } from '../../services/author.service';

@Component({
  selector: 'app-author',
  imports: [],
  templateUrl: './author.component.html',
  styleUrl: './author.component.css'
})
export class AuthorComponent {

  // author!: Author;

  // constructor(private authorService: AuthorService) { }

  // ngOnInit() {
  //   this.authorService.findById(1).subscribe({
  //     next: data => this.author = data,
  //     error: error => console.error(error),
  //     complete: () => console.log('Request completed')
  //   });
  // }

  @Input() author!: Author;
}