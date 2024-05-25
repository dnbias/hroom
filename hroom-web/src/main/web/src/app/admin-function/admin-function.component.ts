import { Component } from '@angular/core';
import {User} from "../shared/models/user";
import {AdminService} from "../service/admin/admin.service";
import { UserService } from '../service/user/user.service';

@Component({
  selector: 'app-admin-function',

  templateUrl: './admin-function.component.html',
  styleUrl: './admin-function.component.css'
})
export class AdminFunctionComponent {
  users: User[] = [];
  utentilista:User[]=[];
  constructor(private svcUser: UserService,
              private svcAdmin: AdminService) { }

  ngOnInit(): void {
    this.loadUsers();
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

  banUser(userId: number, i: number): void {
    this.svcAdmin.banUserById(userId).subscribe(
      res => {
        console.log(res)
        console.log('User banned successfully');
        this.users.splice(i, 1);
        this.loadUsers();
      }
    );
  }

}
