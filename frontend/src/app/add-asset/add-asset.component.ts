import { Component, Output, EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Asset } from '../services/assetService/asset.service';

@Component({
  selector: 'app-add-asset',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './add-asset.component.html',
  styleUrl: './add-asset.component.css',
})
export class AddAssetComponent {
  @Output() close = new EventEmitter<void>();
  @Output() submitAsset = new EventEmitter<Asset>();

  asset = { name: '', type: '', status: 'RUNNING' };

  submitForm() {
    this.close.emit();
    this.submitAsset.emit(this.asset);
  }

  closeForm() {
    this.close.emit();
  }
}
