import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AuthorsComponent } from "./components/authors/authors.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AuthorsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'practica7';
}
