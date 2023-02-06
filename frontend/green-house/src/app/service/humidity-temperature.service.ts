import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HumidityTemperatureDataModel} from "../models/humidity-temperature-data.model";
import {environment} from "../../environments/environment";


const BASE_URL = environment.serverUrl;

@Injectable({
    providedIn: 'root'
})

export class HumidityTemperatureService {


    constructor(private http: HttpClient) {
    }

    fetchData(period: string): Observable<Array<HumidityTemperatureDataModel>> {
        return this.http.get<Array<HumidityTemperatureDataModel>>(BASE_URL + '/api/humidity-temperatures/get-data' + '/' + period);
    }
}
