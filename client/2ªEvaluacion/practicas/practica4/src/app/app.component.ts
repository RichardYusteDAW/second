import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ArticlesComponent } from "./components/articles/articles.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ArticlesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'practica4';
}
