import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStanze} from "../../models/Stanze";


@Component({
  selector: 'app-stanze-card',
  templateUrl: './stanze-card.component.html',
  styleUrls: ['./stanze-card.component.css']
})
export class StanzeCardComponent implements OnInit{
  constructor() {
  }
  //variabile di Input
    @Input()
    stanza: IStanze={
      codSta:'',
      descrizione:'',
      prezzo : 0,
      citta: '',
      valutazione : 0,
      active: true,
      data: new Date(),
      imageUrl: ''
    };
  @Output()
    delete = new EventEmitter();
  @Output()
    edit = new EventEmitter();
  ngOnInit(): void {
  }
  editSta =() => this.edit.emit(this.stanza.codSta);
  delSta =() => this.delete.emit(this.stanza.codSta);
}
