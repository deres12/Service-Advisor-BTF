import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaFornitoriComponent } from './lista-fornitori.component';

describe('ListaFornitoriComponent', () => {
  let component: ListaFornitoriComponent;
  let fixture: ComponentFixture<ListaFornitoriComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaFornitoriComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaFornitoriComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
