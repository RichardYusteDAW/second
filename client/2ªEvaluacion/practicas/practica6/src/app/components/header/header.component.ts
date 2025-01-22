import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Subscription } from 'rxjs';
import { ArticuloService } from '../../services/articulo.service';

@Component({
  selector: 'app-header',
  imports: [RouterLink],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  contador: number = 0;
  subscription: Subscription = new Subscription();

  constructor(private articuloService: ArticuloService) { }

  ngOnInit() {
    this.subscription = this.articuloService.contador$.subscribe({
      next: data => this.contador = data,
      error: err => console.error(err),
      complete: () => console.log('Completado')
    });
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}