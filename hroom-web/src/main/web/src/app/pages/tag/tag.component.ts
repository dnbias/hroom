import {Component, Input, OnInit} from '@angular/core';
import {Tag, TagUtility} from "../../shared/models/tags"
import { HomeComponent } from '../home/home.component';
@Component({
  selector: 'app-tag',

  templateUrl: './tag.component.html',
  styleUrl: './tag.component.css'
})
export class TagComponent implements OnInit{
  @Input() tags?:string[];
  @Input() justifyContent?:string = 'center';

  constructor(
    public home: HomeComponent,
    public tagUtil: TagUtility) {}

  ngOnInit(): void {
    if(!this.tags)
      this.tags = this.tagUtil.getAllTags();
  }
}
