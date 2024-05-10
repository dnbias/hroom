import {Component, Input, OnInit} from '@angular/core';
import {StanzaService} from "../../service/stanza/stanza.service";
import {Tag} from "../../shared/models/tags"
@Component({
  selector: 'app-tag',

  templateUrl: './tag.component.html',
  styleUrl: './tag.component.css'
})
export class TagComponent implements OnInit{
  @Input()  stanzaPageTags?:string[];
  @Input() tags?:Tag[]=[];
  @Input()  justifyContent?:string = 'center';



  constructor(private ss :StanzaService) {}

  ngOnInit(): void {
    if(!this.stanzaPageTags)
      this.tags = this.ss.getAllTag();

  }
}
