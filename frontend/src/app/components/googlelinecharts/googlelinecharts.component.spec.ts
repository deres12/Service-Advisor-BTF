import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GooglelinechartsComponent } from './googlelinecharts.component';

describe('GooglelinechartsComponent', () => {
  let component: GooglelinechartsComponent;
  let fixture: ComponentFixture<GooglelinechartsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GooglelinechartsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GooglelinechartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
