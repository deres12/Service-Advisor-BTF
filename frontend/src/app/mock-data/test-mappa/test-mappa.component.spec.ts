import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestMappaComponent } from './test-mappa.component';

describe('TestMappaComponent', () => {
  let component: TestMappaComponent;
  let fixture: ComponentFixture<TestMappaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestMappaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestMappaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
