import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardsFornitoriComponent } from './cards-fornitori.component';

describe('CardsFornitoriComponent', () => {
  let component: CardsFornitoriComponent;
  let fixture: ComponentFixture<CardsFornitoriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardsFornitoriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardsFornitoriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
