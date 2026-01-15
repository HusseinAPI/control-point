import { Component } from '@angular/core';
import { RouterModule } from '@angular/router';
import { AddAssetComponent } from '../add-asset/add-asset.component';
import { CommonModule } from '@angular/common';
import { Asset, AssetService } from '../services/assetService/asset.service';

@Component({
  selector: 'app-asset',
  standalone: true,
  imports: [RouterModule, CommonModule, AddAssetComponent],
  templateUrl: './asset.component.html',
  styleUrls: ['./asset.component.css'],
})
export class AssetComponent {
  title = 'Control Point';

  showAddAssetForm: boolean = false;

  assets: Asset[] = [];

  constructor(private assetService: AssetService) {}

  ngOnInit() {
    this.getAssets();
  }

  openForm() {
    this.showAddAssetForm = true;
  }

  closeForm() {
    this.showAddAssetForm = false;
  }

  // Fetch All Asset
  getAssets() {
    this.assetService.getAssets().subscribe({
      next: (data) => (this.assets = data),
      error: (err) => console.error('Error getAssets', err),
    });
  }

  // Add New Asset
  addAsset(asset: Asset) {
    this.assetService.addAsset(asset).subscribe({
      next: (newAsset) => {
        this.assets.push(newAsset);
        this.closeForm();
      },
      error: (err) => console.error('Error addAsset', err),
    });
  }
}
