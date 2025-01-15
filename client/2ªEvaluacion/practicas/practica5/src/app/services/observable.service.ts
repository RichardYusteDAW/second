import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ObservableService {

  private cont = new BehaviorSubject<number>(0);
  cont$ = this.cont.asObservable();

  increment() {
    this.cont.next(this.cont.value + 1);
  }

  complete() {
    this.cont.complete();
  }
}