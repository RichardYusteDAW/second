import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateArticleComponent } from './update-article.component';

describe('UpdateArticleComponent', () => {
  let component: UpdateArticleComponent;
  let fixture: ComponentFixture<UpdateArticleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateArticleComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
