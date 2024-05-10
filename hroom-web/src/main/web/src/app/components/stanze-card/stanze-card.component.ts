import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {IStanze} from "../../models/Stanze";
import {stanze} from "../../shared/models/stanza";
import {Tag} from "../../shared/models/tags";


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
      categoria:'',
      prezzo : 0,
      citta: '',
      valutazione : 0,
      active: true,
      data: new Date(),
      imageUrl: ''
    };
  @Input()
    room: {
      roomtime: number;
      imageUrl: string;
      nomeHost: string;
      prezzo: number;
      nome: string;
      id: number;
      favorite: boolean;
      stelle: number
    }={
      id:0,
      prezzo:0,
      nome :'',
      favorite: false,
      stelle: 0,
      imageUrl: '',
      roomtime: 0,
      nomeHost:''
  };
  @Output()
    delete = new EventEmitter();
  @Output()
    edit = new EventEmitter();
  ngOnInit(): void {
  }
  editSta =() => this.edit.emit(this.stanza.codSta);
  delSta =() => this.delete.emit(this.stanza.codSta);
  modifica=()=>this.delete.emit(this.room.id);
  cancella=()=>this.delete.emit(this.room.id);
}
