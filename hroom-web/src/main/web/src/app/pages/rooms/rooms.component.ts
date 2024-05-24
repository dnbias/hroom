import {Component, OnInit} from '@angular/core';
import {InsertionService} from "../../service/insertion/insertion.service"
import {FormsModule} from "@angular/forms";
import {HttpClient} from "@angular/common/http";
import {insertion} from "../../shared/models/insertion";
import { ToastrService } from 'ngx-toastr'
import {TagUtility} from "../../shared/models/tags";

@Component({
  selector: 'app-rooms',
  templateUrl: './rooms.component.html',
  styleUrl: './rooms.component.css'
})

export class RoomsComponent implements OnInit {

  insertionList: any[] = [];
  tagLists: any[] = [];

  insertionData: insertion = {
    "insertion_type": 'room',
    "id": 1,
    "landlordId": 1,
    "name": '',
    "tags": [],
    "description": [''],
    "price": 0,
    "city": '',
    "address": '',
    "area": 0,
    "photoIds": [],
    "rating": 0,
    "receivedFeedbacksIds": [],
    "availabilityId": 0,
  };
  availableTags: string[] = [
    'BATHROOM', 'HYDROMASSAGE', 'WHEELCHAIR_ACCESS', 'SPA', 'ALLINCLUSIVE',
    'CENTER', 'APARTMENT', 'ROOM', 'PRIVATEBATHROOM', 'SEA', 'MONTAIN',
    'MAISON', 'PARKING', 'AIRCONDITIONER', 'BREAKFAST', 'GYM', 'CLEAN',
    'MASSAGE', 'FREEZER', 'TV', 'WC', 'MINIBAR', 'BIDET'
  ];
  ins = {
    tags: [] as string[]
  };
  dropdownOpen = false;

  toggleDropdown() {
    this.dropdownOpen = !this.dropdownOpen;
  }
  toggleTag(event: Event, tag: string) {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      this.ins.tags.push(tag);
    } else {
      const index = this.ins.tags.indexOf(tag);
      if (index > -1) {
        this.ins.tags.splice(index, 1);
      }
    }
  }
  insertionsArray: insertion[] = [];

  toggleTag(event: Event, tag: string) {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      this.ins.tags.push(tag);
    } else {
      const index = this.ins.tags.indexOf(tag);
      if (index > -1) {
        this.ins.tags.splice(index, 1);
      }
    }
  }

  insertionsArray: insertion[] = [];


  removeRiga(index: number) {
    this.insertionList.splice(index, 1);
    this.resetTags();
  }

  resetTags() {
    this.insertionList.forEach(item => {
      item.tags = [];
    });
  }



  removeRiga(index: number) {
    this.insertionList.splice(index, 1);
    this.tagLists.splice(index, 1);
    this.resetTags();
  }

  resetTags() {
    this.insertionList.forEach(item => {
      item.tags = [];
    });
  }

  addRoom() {
  }

  constructor(private svc: InsertionService,
              private toastr: ToastrService,
              private http: HttpClient,
              protected tagUtility: TagUtility) {
    this.insertionsArray = [];
  }

  newUri = '';

  ngOnInit(): void {
    this.availableTags = this.tagUtility.getAllTags();
    this.testPhotoUpload();
  }

  getAllRooms() {
    // this.roomSrv.getAllRooms().subscribe((res:any)=>{
    this.svc.fetchInsertionList().subscribe((res: any) => {
      this.insertionList = res.data;
    })
  }

  saveRooms() {
    this.insertionList.forEach((item, index) => {
      item.tags = this.tagLists[index];
      this.svc.saveInsertion(item).subscribe((res: any) => {
        if (res.result) {
          this.toastr.success('OK', 'Insertions Uploaded')
        } else {
          this.toastr.error('ERROR INSERIMENTO DATI', res.message);
        }
      });
    });
  }

  AddNewRoom() {
    const newRow = {
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
      photoIds: [],
      rating: 0,
      receivedFeedbacksIds: [],
      availabilityId: 0,
    }
    this.insertionList.unshift(newRow)
    this.tagLists.unshift([]);
  }


  onDelete(id: number) {
    this.svc.deleteInsertion(id).subscribe((res: any) => {
      if (res.status == 200 || res.status == 201) {
        this.toastr.success('Room deleted success');
        this.getAllRooms();
      } else {
        this.toastr.error('ERROR CANCELLAZIONE', res.message);
      }
    })
  }

  /*
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
      });
    }
  */

  uploadPhoto(event: any, index: number) {
    const file = event.target.files[0];
    if (file) {
      this.svc.uploadPhoto(file).subscribe((res: any) => {
        console.log(res);
        if (res.status === 200 || res.status === 201) {
          this.newUri = res.body;
          this.toastr.success('OK', 'Photo Uploaded');
          this.insertionList[index].photoIds.push(this.newUri);
        } else {
          this.toastr.error('ERROR: ' + res.status, 'Photo Upload failed');
        }
      });
    }
  }

  testPhotoUpload() {
    this.http.get('assets/images/test.png', {responseType: 'blob'})
      .subscribe(res => {
        this.uploadPhoto(res, 0);
      });
  }
}

    /*
  testPhotoUpload() {
    console.log('Testing upload w/ test.png')
    this.http.get('assets/images/test.png', { responseType: 'blob' })
      .subscribe(res => {
        this.uploadPhoto({ target: { files: [res] } }, 0);
       // this.uploadPhoto(res);
      });
  }

     */





