import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from "./components/header/header.component";
import { ArticlesComponent } from "./components/articles/articles.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, ArticlesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'practica8';
}