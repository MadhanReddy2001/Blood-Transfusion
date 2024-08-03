import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewdonorComponent } from './viewdonor.component';

describe('ViewdonorComponent', () => {
  let component: ViewdonorComponent;
  let fixture: ComponentFixture<ViewdonorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ViewdonorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ViewdonorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
