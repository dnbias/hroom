import {Component, OnInit} from '@angular/core';
import { UserService } from '../../service/user/user.service';
import { User } from '../../shared/models/user';
@Component({
  selector: 'app-lista-utenti',

  templateUrl: './lista-utenti.component.html',
  styleUrl: './lista-utenti.component.css'
})
export class ListaUtentiComponent implements OnInit {
  users: User[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getUsers();
  }


  getUsers() {
    // this.roomSrv.getAllRooms().subscribe((res:any)=>{
    this.userService.fetchUserList().subscribe((res: any) => {
      this.users = res.data;
    })
  }

  deleteUser(userId: number): void {
    this.userService.deleteUserById(userId).subscribe(response => {
      this.users = this.users.filter(user => user.id !== userId);
      console.log(response);
    });
  }

  banUser(userId: number): void {
    this.userService.banUserById(userId).subscribe(response => {
      const user = this.users.find(u => u.id === userId);
      if (user) {
        user.banned = true;
      }
      console.log(response);
    });
  }

}
