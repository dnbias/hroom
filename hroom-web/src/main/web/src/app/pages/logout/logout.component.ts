import {Component, OnInit} from '@angular/core';
import { CommonModule } from '@angular/common';
import {AuthappService} from "../../../services/authapp.service";

@Component({
  selector: 'app-logout',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.css'
})
export class LogoutComponent implements OnInit{
  constructor(private BasicAuth: AuthappService) {
  }
  ngOnInit(): void {
    this.BasicAuth.clearAll();
  }

}
