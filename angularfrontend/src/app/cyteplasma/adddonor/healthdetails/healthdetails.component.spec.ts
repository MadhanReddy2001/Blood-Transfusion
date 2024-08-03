import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthdetailsComponent } from './healthdetails.component';

describe('HealthdetailsComponent', () => {
  let component: HealthdetailsComponent;
  let fixture: ComponentFixture<HealthdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HealthdetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(HealthdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
