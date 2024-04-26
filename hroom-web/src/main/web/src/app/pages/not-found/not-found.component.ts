import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-not-found',
  templateUrl: './not-found.component.html',
  styleUrl: './not-found.component.css'
})
export class NotFoundComponent implements OnInit{
  visible: boolean=false;
  notFoundMessage: string = 'Nothing Found!';
  resetLinkText:string = 'Reset';
  resetLinkRoute:string ='/';
  constructor() {
  }

  ngOnInit(): void {

    }
}
