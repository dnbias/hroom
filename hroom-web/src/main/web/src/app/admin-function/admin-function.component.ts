import { Component } from '@angular/core';
import {User} from "../shared/models/user";
import {AdminService} from "../service/admin/admin.service";
import { UserService } from '../service/user/user.service';
import { insertion } from '../shared/models/insertion';
import { InsertionService } from '../service/insertion/insertion.service';

@Component({
  selector: 'app-admin-function',

  templateUrl: './admin-function.component.html',
  styleUrl: './admin-function.component.css'
})
export class AdminFunctionComponent {

  users: User[] = [];
  photos: number[] = [];
  insertions: insertion[] = [];

  userTableEnabled : boolean = true;
  insTableEnabled : boolean = false;
  photoTableEnabled : boolean = false;

  tableName = "User";

  utentilista:User[]=[];
  constructor(private svcUser: UserService,
              private svcInsertion: InsertionService,
              private svcAdmin: AdminService) { }

  ngOnInit(): void {
    this.loadUsers();
  }

  openTab(name: any): void {
    this.tableName = name;
    switch (name) {
        case "Users":
            this.userTableEnabled = true;
            this.insTableEnabled = false;
            this.photoTableEnabled = false;
            if (this.insertions.length == 0)
              this.loadUsers();
            break;
        case "Insertions":
            this.userTableEnabled = false;
            this.insTableEnabled = true;
            this.photoTableEnabled = false;
            if (this.insertions.length == 0)
              this.loadInsertions();
            break;
            break;
        case "Photos":
            this.userTableEnabled = false;
            this.insTableEnabled = false;
            this.photoTableEnabled = true;
            if (this.photos.length == 0)
              this.loadPhotos();
            break;
            break;
    }
  }

  loadUsers(): void {
    this.svcUser.fetchUserList().subscribe(
      (userslista) => {
        this.users=userslista;
      },
      error => {
        console.error('Error fetching user list', error);
      }
    );
  }

  loadInsertions(): void {
    this.svcInsertion.fetchInsertionList().subscribe(
      (list) => {
        this.insertions=list;
      },
      error => {
        console.error('Error fetching insertion list', error);
      }
    );
  }

  loadPhotos(): void {
    this.svcInsertion.fetchPhotoList().subscribe(
      (list) => {
        this.photos=list;
      },
      error => {
        console.error('Error fetching Photo list', error);
      }
    );
  }

  banUser(userId: number, i: number): void {
    this.svcAdmin.banUserById(userId).subscribe(
      res => {
        console.log(res)
        console.log('User banned successfully');
        this.users.splice(i, 1);
        // this.loadUsers();
      }
    );
  }

  deleteInsertion(insId: number, i: number): void {
    this.svcAdmin.deleteInsertionById(insId).subscribe(
      res => {
        console.log(res)
        console.log('Insertion deleted successfully');
        this.insertions.splice(i, 1);
        // this.loadUsers();
      }
    );
  }

  deletePhoto(photoId: number, i: number): void {
    this.svcAdmin.deletePhotoById(photoId).subscribe(
      res => {
        console.log(res)
        console.log('Photo deleted successfully');
        this.photos.splice(i, 1);
        // this.loadUsers();
      }
    );
  }

}
