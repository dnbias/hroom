import {Component, EventEmitter, Output} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {insertion} from "../../shared/models/insertion";

@Component({
  selector: 'app-popup-add',
  templateUrl: './popup-add.component.html',
  styleUrl: './popup-add.component.css'
})
export class PopupAddComponent {

  @Output() addRoom = new EventEmitter<any>();

  roomData = {
    "insertion_type": 'room',
    "id": null,
    "landlordId": null,
    "name": '',
    "tags": [],
    "description": [''],
    "price": null,
    "city": '',
    "address": '',
    "area": null,
    "photoIds": [],
    "rating": null,
    "receivedFeedbacksIds": [],
    "availabilityId": null
  };

  submitRoom() {
    this.addRoom.emit(this.roomData);
  }
  @Output() close = new EventEmitter<void>();

  // Metodo per chiudere il popup
  closePopup() {
    this.close.emit();
  }
  showPopup: boolean = false;

  // Metodo per aprire il popup
  openPopup() {
    this.showPopup = true;
  }
}
