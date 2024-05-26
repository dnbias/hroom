import {Component, Input, OnInit} from '@angular/core';
import {TagUtility} from "../../../shared/models/tags"
import {HomeComponent} from '../../home/home.component';
@Component({
  selector: 'app-tag-button',

  templateUrl: './tag.button.component.html',
  styleUrl: './tag.button.component.css'
})
export class TagButtonComponent implements OnInit{
  @Input() tags?:string[];
  @Input() justifyContent:string = 'center';
  tagStatus:boolean[]=[];

  constructor(
    public home: HomeComponent,
    public tagUtil: TagUtility) {}

  ngOnInit(): void {
    if(!this.tags)
      this.tags = this.tagUtil.getAllTags();
    this.tags.forEach(_ =>
      this.tagStatus.push(false))
  }

  toggle(tag,i) {
    this.tagStatus[i] = !this.tagStatus[i];
    this.home.toggleTagToFilter(tag);
  }
}
