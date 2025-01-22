import { Component } from '@angular/core';
import { Articulo } from '../../models/articulo';
import { ArticuloService } from '../../services/articulo.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-verarticulo',
  imports: [FormsModule, RouterLink],
  templateUrl: './verarticulo.component.html',
  styleUrl: './verarticulo.component.css'
})
export class VerarticuloComponent {
  articulo!: Articulo;
  constructor(private articuloService: ArticuloService, private router: Router, private myroute: ActivatedRoute) { }

  ngOnInit() {
    this.myroute.params
      .subscribe(p => {
        const art = this.articuloService.getById(p['id']);
        if (art) {
          this.articulo = art;
        } else {
          this.router.navigate(['/error']);
        }
      });
  }

  update() {
    this.articuloService.update(this.articulo);
    this.router.navigate(['/articulos']);
  }
}