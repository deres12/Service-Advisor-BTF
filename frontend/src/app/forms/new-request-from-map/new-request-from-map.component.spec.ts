import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewRequestFromMapComponent } from './new-request-from-map.component';

describe('NewRequestFromMapComponent', () => {
  let component: NewRequestFromMapComponent;
  let fixture: ComponentFixture<NewRequestFromMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewRequestFromMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewRequestFromMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
