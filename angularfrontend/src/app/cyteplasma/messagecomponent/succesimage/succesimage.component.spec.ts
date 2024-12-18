import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccesimageComponent } from './succesimage.component';

describe('SuccesimageComponent', () => {
  let component: SuccesimageComponent;
  let fixture: ComponentFixture<SuccesimageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SuccesimageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SuccesimageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
