import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NuevoarticuloComponent } from './nuevoarticulo.component';

describe('NuevoarticuloComponent', () => {
  let component: NuevoarticuloComponent;
  let fixture: ComponentFixture<NuevoarticuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NuevoarticuloComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NuevoarticuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
