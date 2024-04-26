import {Component, OnInit} from '@angular/core';
import {StanzaService} from "../../../service/stanza/stanza.service";
import {Tag} from "../../shared/models/Tag";
@Component({
  selector: 'app-tag',

  templateUrl: './tag.component.html',
  styleUrl: './tag.component.css'
})
export class TagComponent implements OnInit{
  tags:Tag[]=[];

  constructor(private ss :StanzaService) {}

  ngOnInit(): void {
    this.tags = this.ss.getAllTag();

  }
}
