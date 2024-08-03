import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckeligibilityComponent } from './checkeligibility.component';

describe('CheckeligibilityComponent', () => {
  let component: CheckeligibilityComponent;
  let fixture: ComponentFixture<CheckeligibilityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CheckeligibilityComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CheckeligibilityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
