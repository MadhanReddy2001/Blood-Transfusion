import { TestBed } from '@angular/core/testing';

import { AdddonorService } from './adddonor.service';

describe('AdddonorService', () => {
  let service: AdddonorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdddonorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
