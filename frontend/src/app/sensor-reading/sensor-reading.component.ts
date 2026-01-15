import { Component } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import {
  SensorReading,
  SensorService,
} from '../services/sensorService/sensor.service';
import { CommonModule } from '@angular/common';
import { Asset, AssetService } from '../services/assetService/asset.service';

@Component({
  selector: 'app-sensor-reading',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './sensor-reading.component.html',
  styleUrls: ['./sensor-reading.component.css'],
})
export class SensorReadingComponent {
  constructor(
    private route: ActivatedRoute,
    private sensorService: SensorService,
    private assetService: AssetService
  ) {}

  sensorDetails?: SensorReading;
  assetDetails?: Asset;

  ngOnInit(): void {
    const assetId = Number(this.route.snapshot.paramMap.get('assetId'));

    if (assetId) {
      // Get Asset selcted data
      this.assetService.getAssetById(assetId).subscribe({
        next: (asset) => {
          this.assetDetails = asset;
        },
        error: (err) => console.error('Asset not found', err),
      });

      // Get Asset selected Sensor Details
      this.sensorService.getSensorReading(assetId).subscribe({
        next: (data) => {
          this.sensorDetails = data;
        },
        error: (err) => console.error('Sensor not found', err),
      });
    }
  }
}
