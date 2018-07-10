import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MappaAGMComponent } from './mappa-agm.component';

describe('MappaAGMComponent', () => {
  let component: MappaAGMComponent;
  let fixture: ComponentFixture<MappaAGMComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MappaAGMComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MappaAGMComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
