import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ArticuloService } from '../../services/articulo.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-eliminararticulo',
  imports: [RouterLink],
  templateUrl: './eliminararticulo.component.html',
  styleUrl: './eliminararticulo.component.css'
})
export class EliminararticuloComponent {

  paramsId!: Subscription;

  constructor(private myroute: ActivatedRoute, private router: Router, private articuloService: ArticuloService) { }

  eliminarArticulo() {
    this.paramsId = this.myroute.params.subscribe(p => this.articuloService.delete(p["id"]));
    this.router.navigate(['/articulos']);
  }

  ngDestroy() {
    this.paramsId.unsubscribe();
  }
}
