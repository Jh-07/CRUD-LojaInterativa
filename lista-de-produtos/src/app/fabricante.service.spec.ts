import { TestBed } from '@angular/core/testing';

import { FabricanteService } from './fabricante.service';

describe('FabricanteService', () => {
  let service: FabricanteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FabricanteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
