import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchVendorComponent } from './search-vendor.component';

describe('SearchPageComponent', () => {
  let component: SearchVendorComponent;
  let fixture: ComponentFixture<SearchVendorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SearchVendorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchVendorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
