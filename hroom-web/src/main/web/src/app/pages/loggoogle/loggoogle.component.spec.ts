import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoggoogleComponent } from './loggoogle.component';

describe('LoggoogleComponent', () => {
  let component: LoggoogleComponent;
  let fixture: ComponentFixture<LoggoogleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LoggoogleComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LoggoogleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
