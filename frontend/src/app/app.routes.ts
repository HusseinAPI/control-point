import { Routes } from '@angular/router';
import { SensorReadingComponent } from './sensor-reading/sensor-reading.component';
import { AssetComponent } from './asset/asset.component';
import { AppComponent } from './app.component';

export const routes: Routes = [
  {
    path: '',
    component: AppComponent,
    children: [
      { path: '', component: AssetComponent },
      { path: 'sensor-reading/:assetId', component: SensorReadingComponent },
    ],
  },
];
