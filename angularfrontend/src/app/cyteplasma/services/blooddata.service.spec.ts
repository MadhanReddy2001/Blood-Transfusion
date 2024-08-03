import { TestBed } from '@angular/core/testing';

import { BlooddataService } from './blooddata.service';

describe('BlooddataService', () => {
  let service: BlooddataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BlooddataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
