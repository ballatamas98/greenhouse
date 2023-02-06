import {ComponentFixture, TestBed} from '@angular/core/testing';

import {HumidityTemperatureChartComponent} from './humidity-temperature-chart.component';

describe('HumidityTemperatureChartComponent', () => {
  let component: HumidityTemperatureChartComponent;
  let fixture: ComponentFixture<HumidityTemperatureChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [HumidityTemperatureChartComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(HumidityTemperatureChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
