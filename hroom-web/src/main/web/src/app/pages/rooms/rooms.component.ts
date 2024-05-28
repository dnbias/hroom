import {Component, OnInit, HostListener} from '@angular/core';
import {InsertionService} from "../../service/insertion/insertion.service"
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
  file: any=null;

  insertionData: insertion = {
    "insertion_type": 'room',
    "id": 1,
    "landlordId": 1,
    "name": '',
    "features": [],
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
    // 'BATHROOM', 'HYDROMASSAGE', 'WHEELCHAIR_ACCESS', 'SPA', 'ALLINCLUSIVE',
    // 'CENTER', 'APARTMENT', 'ROOM', 'PRIVATEBATHROOM', 'SEA', 'MONTAIN',
    // 'MAISON', 'PARKING', 'AIRCONDITIONER', 'BREAKFAST', 'GYM', 'CLEAN',
    // 'MASSAGE', 'FREEZER', 'TV', 'WC', 'MINIBAR', 'BIDET'
  ];
  ins = {
    tags: [] as string[]
  };
  dropdownOpen = false;
  insertionsArray: insertion[] = [];
  newUri = 1;

  constructor(private svc: InsertionService,
              private toastr: ToastrService,
              private http: HttpClient,
              protected tagUtility: TagUtility) {
    this.insertionsArray = [];
  }

  toggleDropdown() {
    this.dropdownOpen = !this.dropdownOpen;
  }

  toggleTag(event: Event, tag: string, ins: any) {
    const checkbox = event.target as HTMLInputElement;
    if (checkbox.checked) {
      ins.features.push(tag);
    } else {
      const index = ins.features.indexOf(tag);
      if (index > -1) {
        ins.features.splice(index, 1);
      }
    }
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

  ngOnInit(): void {
    this.availableTags = this.tagUtility.getAllTags();
    // this.testPhotoUpload();
  }

  getAllRooms() {
    // this.roomSrv.getAllRooms().subscribe((res:any)=>{
    this.svc.fetchInsertionList().subscribe((res: any) => {
      this.insertionList = res.data;
    })
  }

  saveRooms() {
    console.log("saveRooms")
    this.insertionList.forEach((item, index) => {
      console.log(item)
      this.svc.saveInsertion(item).subscribe((res: any) => {
        if (res) {
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
      features: [],
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

  @HostListener('change', ['$event.target.files']) emitFiles( event: FileList ) {
    const file = event && event.item(0);
    this.file = file;
    console.log(file);
    this.uploadPhoto(file, 0)
  }

  uploadPhoto(file: any, index: number) {
    if (file) {
      console.log(file);
      this.svc.uploadPhoto(file).subscribe((res: any) => {
        if (res) {
          this.newUri = parseInt(res);
          this.toastr.success('OK', 'Photo Uploaded');
          this.insertionList[index].photoIds.push(this.newUri);
        } else {
          this.toastr.error('ERROR: ' + res.status, 'Photo Upload failed');
        }
      });
    }
  }

  // testPhotoUpload() {
  //   console.log('Testing upload w/ test.png')
  //   const ph = fs.readFileSync('../../../assets/images/test.jpeg')
  //   this.uploadPhoto(ph, 0);
  // }
}
