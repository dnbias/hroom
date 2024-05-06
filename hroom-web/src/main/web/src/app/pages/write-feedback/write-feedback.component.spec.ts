import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WriteFeedbackComponent } from './write-feedback.component';

describe('WriteFeedbackComponent', () => {
  let component: WriteFeedbackComponent;
  let fixture: ComponentFixture<WriteFeedbackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WriteFeedbackComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WriteFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
