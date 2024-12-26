import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrabajadoresComponent } from './trabajadores.component';

describe('TrabajadoresComponent', () => {
  let component: TrabajadoresComponent;
  let fixture: ComponentFixture<TrabajadoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TrabajadoresComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrabajadoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
