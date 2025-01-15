import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Component1Component } from './components/component1/component1.component';
import { Component2Component } from "./components/component2/component2.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Component1Component, Component2Component],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'practica5';
}