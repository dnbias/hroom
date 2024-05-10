import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StanzeModificaComponent } from './stanze-modifica.component';

describe('StanzeModificaComponent', () => {
  let component: StanzeModificaComponent;
  let fixture: ComponentFixture<StanzeModificaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StanzeModificaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StanzeModificaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
