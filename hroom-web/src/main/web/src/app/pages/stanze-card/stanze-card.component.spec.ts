import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StanzeCardComponent } from './stanze-card.component';

describe('StanzeCardComponent', () => {
  let component: StanzeCardComponent;
  let fixture: ComponentFixture<StanzeCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StanzeCardComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StanzeCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
