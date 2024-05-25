import { Component } from '@angular/core';
import {User} from "../shared/models/user";
import {UserService} from "../service/user/user.service";
import {SignUpRequest} from "../shared/models/signUpRequest";

@Component({
  selector: 'app-admin-function',

  templateUrl: './admin-function.component.html',
  styleUrl: './admin-function.component.css'
})
export class AdminFunctionComponent {



  users: User[] = [];
  utentilista:User[]=[];
  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.userService.fetchUserList().subscribe(
      (userslista) => {
        this.users=userslista;
      },
      error => {
        console.error('Error fetching user list', error);
      }
    );
  }
  deleteUser(userId: number): void {
    this.userService.deleteUserById(userId).subscribe(
      () => {
        console.log('User deleted successfully');
        this.loadUsers();
      },
      error => {
        console.error('Error deleting user', error);
      }
    );
  }


}
