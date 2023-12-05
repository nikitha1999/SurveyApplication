import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAllSurveysComponent } from './list-all-surveys.component';

describe('ListAllSurveysComponent', () => {
  let component: ListAllSurveysComponent;
  let fixture: ComponentFixture<ListAllSurveysComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListAllSurveysComponent]
    });
    fixture = TestBed.createComponent(ListAllSurveysComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
