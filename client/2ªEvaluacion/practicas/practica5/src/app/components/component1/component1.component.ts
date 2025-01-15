import { Component } from '@angular/core';
import { ObservableService } from '../../services/observable.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-component1',
  imports: [],
  templateUrl: './component1.component.html',
  styleUrl: './component1.component.css'
})
export class Component1Component {

  title: string = 'Componente 1';
  cont: number = 0;
  suscription: Subscription = new Subscription;

  constructor(private observableService: ObservableService) {
  }

  ngOnInit() {
    this.suscription = this.observableService.cont$.subscribe({
      next: data => this.cont = data,
      error: e => console.log(e),
      complete: () => console.log("Completed"),
    });
  }

  increment() {
    this.observableService.increment();
  }

  complete() {
    this.observableService.complete();
  }

  unsubscribe() {
    this.suscription.unsubscribe();
  }
}