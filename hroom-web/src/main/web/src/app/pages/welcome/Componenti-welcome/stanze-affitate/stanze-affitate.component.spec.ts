import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StanzeAffitateComponent } from './stanze-affitate.component';

describe('StanzeAffitateComponent', () => {
  let component: StanzeAffitateComponent;
  let fixture: ComponentFixture<StanzeAffitateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StanzeAffitateComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StanzeAffitateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
