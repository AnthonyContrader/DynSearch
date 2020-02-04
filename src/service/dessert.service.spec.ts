import { TestBed } from '@angular/core/testing';

import { DessertService } from './dessert.service';

describe('DessertService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DessertService = TestBed.get(DessertService);
    expect(service).toBeTruthy();
  });
});
