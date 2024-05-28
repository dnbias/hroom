import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StanzaPageComponent } from './stanza-page.component';

describe('StanzaPageComponent', () => {
  let component: StanzaPageComponent;
  let fixture: ComponentFixture<StanzaPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StanzaPageComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(StanzaPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
