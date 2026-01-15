import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface SensorReading {
  id: number;
  assetId: number;
  temperature: number;
  pressure: number;
  timestamp: string;
}

@Injectable({
  providedIn: 'root',
})
export class SensorService {
  private apiUrl = 'http://localhost:8080/sensor';

  constructor(private http: HttpClient) {}

  getSensorReading(id: number): Observable<SensorReading> {
    return this.http.get<SensorReading>(`${this.apiUrl}/${id}`);
  }
}
