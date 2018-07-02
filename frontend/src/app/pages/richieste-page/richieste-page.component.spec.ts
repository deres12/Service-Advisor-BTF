import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RichiestePageComponent } from './richieste-page.component';

describe('RichiestePageComponent', () => {
  let component: RichiestePageComponent;
  let fixture: ComponentFixture<RichiestePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RichiestePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RichiestePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
