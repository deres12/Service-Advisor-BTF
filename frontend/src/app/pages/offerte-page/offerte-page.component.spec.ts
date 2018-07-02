import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OffertePageComponent } from './offerte-page.component';

describe('OffertePageComponent', () => {
  let component: OffertePageComponent;
  let fixture: ComponentFixture<OffertePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OffertePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OffertePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
