import { TestBed } from '@angular/core/testing';

import { CadProfessoresService } from './cad-professores.service';

describe('CadProfessoresService', () => {
  let service: CadProfessoresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CadProfessoresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
