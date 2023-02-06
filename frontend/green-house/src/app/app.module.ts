import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {
    HumidityTemperatureChartComponent
} from './component/humidity-temperature-chart/humidity-temperature-chart.component';
import {HttpClientModule} from "@angular/common/http";
import {NgChartsModule} from "ng2-charts";
import {FormsModule} from "@angular/forms";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

@NgModule({
    declarations: [
        AppComponent,
        HumidityTemperatureChartComponent
    ],
    imports: [
        BrowserModule,
        HttpClientModule,
        NgChartsModule,
        FormsModule,
        NgbModule
    ],
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule {
}
