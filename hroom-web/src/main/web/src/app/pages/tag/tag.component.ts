import {Component, Input, OnInit} from '@angular/core';
import {Tag, Tags} from "../../shared/models/tags"
import { InsertionService } from '../../service/insertion/insertion.service';
@Component({
  selector: 'app-tag',

  templateUrl: './tag.component.html',
  styleUrl: './tag.component.css'
})
export class TagComponent implements OnInit{
  @Input() insertionPageTags?:string[];
   tags?:Tag[]=[];

  @Input() justifyContent?:string = 'center';

  constructor(private svc: InsertionService) {}

  ngOnInit(): void {
    if(!this.insertionPageTags)
      this.tags = this.svc.getAllTags();

  }
}
