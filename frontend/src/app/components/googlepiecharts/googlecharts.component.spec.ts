import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GooglechartsComponent } from './googlecharts.component';

describe('GooglechartsComponent', () => {
  let component: GooglechartsComponent;
  let fixture: ComponentFixture<GooglechartsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GooglechartsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GooglechartsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
