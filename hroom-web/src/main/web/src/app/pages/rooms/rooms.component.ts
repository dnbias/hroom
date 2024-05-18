import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {RoomService} from "../../service/room/room.service"
import {InsertionService} from "../../service/insertion/insertion.service"
import {FormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {InsertionService} from "../../service/insertion/insertion.service";
import {insertion} from "../../shared/models/insertion";
import {log} from "@angular-devkit/build-angular/src/builders/ssr-dev-server";
import { ToastrService } from 'ngx-toastr'


@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrl: './rooms.component.css'
})
export class RoomsComponent implements OnInit{

  constructor(private insService: InsertionService)  {
  }
  insertionData : insertion={
      insertion_type: 'room',
      id: 0,
      landlordId: 1,
      name: '',
      tags: [],
      description: [''],
      price: 0,
      city: '',
      address: '',
      area: 0,
      photoUrl: '',
      rating: 0,
      receivedFeedbacksIds: [],
      availabilityId: 0,
  }
    addRoom(){}

    ngOnInit(): void {
    }
    OnSubmit(){
    this.insService.saveInsertion(this.insertionData)
        .subscribe(()=>{
            console.log(JSON);


        })
    }


    protected readonly onsubmit = onsubmit;
}

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

  addIns(insertion : insertion){}

  newUri: string = '';

  constructor(private svc: InsertionService,
              private toastr: ToastrService,
              private roomSrv:RoomService,
              private http: HttpClient) { }

  getStanze(){
    return this.http.get(`${this.backendUrl}/stanze`);
  }

  ngOnInit(): void {
    // this.getAllRooms();
    this.testPhotoUpload();
  }

  getAllRooms() {
    // this.roomSrv.getAllRooms().subscribe((res:any)=>{
    this.svc.fetchInsertionList().subscribe((res:any)=>{
      this.roomList = res.data;
    })
  }

  saveRooms() {
    // this.roomSrv.saveUpdateRoom(this.roomList).subscribe((Res:any)=>{
    //   if(Res.result) {
    //     alert('Data Updated Success')
    //   } else {
    //     alert(Res.message)
    //   }
    // })

    // TODO allineare tabella con i dati in src/app/shared/models/insertion.ts
    this.roomList.forEach((item) => {
      this.svc.saveInsertion(item).subscribe(res => {
        console.log(res);
      })
    });
    this.toastr.success('OK','Insertions Uploaded')

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
      if(res.status == 200 || res.status == 201) {
        alert('Room Deleted Success');
        this.getAllRooms();
      } else {
        alert(res.message)
      }
    })
  }

  uploadPhoto(photo: any) {

    // var data = photoFile.arrayBuffer;
    this.svc.uploadPhoto(photo).subscribe((res: Response) => {
      console.log(res);
      if (res.status == 200 || res.status == 201) {
        this.newUri = new String(res.body).toString();
        this.toastr.success('OK','Photo Uploaded');
      } else {
        this.toastr.error('ERROR: '+res.status,
                          'Photo Upload failed');
      }
    })
  }

  testPhotoUpload() {
    console.log('Testing upload w/ test.png')
    this.http.get('assets/images/test.png', { responseType: 'blob' })
      .subscribe(res => {
        this.uploadPhoto(res);
      });
  }
}
