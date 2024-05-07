import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RoomService} from "../../service/room/room.service"
import {FormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrl: './rooms.component.css'
})
export class RoomsComponent {


  roomList:any []= [];
  roomObj: any = {
    "roomId": 0,
    "roomName": "",
    "isAcAvailable": false,
    "roomCapacity": 0,
    "isActive": false,
    "roomTariff": 0,
    "extensionNo": ""
  };
  constructor(private roomSrv:RoomService, private http: HttpClient) {
  }
  private backendUrl = 'http://localhost:8080';

  getStanze(){
    return this.http.get(`${this.backendUrl}/stanze`);
  }

  ngOnInit(): void {
    this.getAllRooms();
  }

  getAllRooms() {
    this.roomSrv.getAllRooms().subscribe((res:any)=>{
      this.roomList = res.data;
    })
  }

  saveRooms() {
    this.roomSrv.saveUpdateRoom(this.roomList).subscribe((Res:any)=>{
      if(Res.result) {
        alert('Data Updated Success')
      } else {
        alert(Res.message)
      }
    })
  }
  AddNEwRoom() {
    const obj = {
      "roomId": 0,
      "roomName": "",
      "isAcAvailable": false,
      "roomCapacity": 0,
      "isActive": false,
      "roomTariff": 0,
      "extensionNo": ""
    }
    this.roomList.unshift(obj)
  }
  onDelete(id: number) {
    this.roomSrv.deletRoom(id).subscribe((res:any)=>{
      if(res.result) {
        alert('Room Deleted Success');
        this.getAllRooms();
      } else {
        alert(res.message)
      }
    })
  }

}


