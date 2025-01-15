import { Component } from '@angular/core';
import { Subscription } from 'rxjs';
import { ObservableService } from '../../services/observable.service';

@Component({
  selector: 'app-component2',
  imports: [],
  templateUrl: './component2.component.html',
  styleUrl: './component2.component.css'
})
export class Component2Component {
  title: string = 'Componente 2';
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