import { TestBed } from '@angular/core/testing';

import { HumidityTemperatureService } from './humidity-temperature.service';

describe('HumidityTemperatureService', () => {
  let service: HumidityTemperatureService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HumidityTemperatureService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
