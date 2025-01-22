import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EliminararticuloComponent } from './eliminararticulo.component';

describe('EliminararticuloComponent', () => {
  let component: EliminararticuloComponent;
  let fixture: ComponentFixture<EliminararticuloComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EliminararticuloComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EliminararticuloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
