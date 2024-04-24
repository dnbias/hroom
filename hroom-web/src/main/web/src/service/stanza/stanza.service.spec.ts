import { TestBed } from '@angular/core/testing';

import { StanzaService } from './stanza.service';

describe('StanzaService', () => {
  let service: StanzaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StanzaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
