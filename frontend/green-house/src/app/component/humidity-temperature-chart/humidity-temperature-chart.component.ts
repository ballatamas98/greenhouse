import {Component, OnInit} from '@angular/core';
import {HumidityTemperatureService} from "../../service/humidity-temperature.service";
import {HumidityTemperatureDataModel} from "../../models/humidity-temperature-data.model";
import {ChartConfiguration, ChartOptions} from "chart.js";

@Component({
  selector: 'app-humidity-temperature-chart',
  templateUrl: './humidity-temperature-chart.component.html',
  styleUrls: ['./humidity-temperature-chart.component.css']
})
export class HumidityTemperatureChartComponent implements OnInit {
  private chartData: HumidityTemperatureDataModel[] = [];
  public lineChartData: ChartConfiguration['data'] | undefined;
  public lineChartOptions: ChartOptions = {
    responsive: true,
    maintainAspectRatio: false,
    scales: {
      x: {
        ticks: {
          autoSkip: true,
          maxRotation: 90,
          minRotation: 90
        }
      }
    }
  };
  protected periods = [
    {code: 'today', displayName: 'Ma'},
    {code: 'yesterday', displayName: 'Tegnap'},
    {code: 'past-week', displayName: 'Elmúlt hét'}
  ];
  public selectedPeriod = 'today';

  public lineChartLegend = true;


  constructor(private humidityTemperatureService: HumidityTemperatureService) {

  }


  ngOnInit() {
    this.fetchChartData()
  }

  protected fetchChartData() {
    this.humidityTemperatureService.fetchData(this.selectedPeriod).subscribe({
      next: value => this.chartData = value,
      complete: () => this.loadChartData()
    })
  }

  private loadChartData() {
    this.lineChartData = {
      labels: this.chartData.map(value => value.date),
      datasets: [
        {
          type: 'line',
          data: this.chartData.map(value => value.temperature),
          fill: true,
          label: "Hőmérséklet",
          tension: 0.5,
          borderColor: 'black',
          backgroundColor: 'rgba(255,0,0,0.3)'
        },
        {
          type: "bar",
          data: this.chartData.map(value => value.humidity),
          label: "Páratartalom",
          borderColor: 'rgb(255, 99, 132)',
          backgroundColor: 'rgba(255, 99, 132, 0.2)'
        }
      ]
    };
  }
}
