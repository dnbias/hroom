import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { insertion } from "../../shared/models/insertion";
import { Tag } from "../../shared/models/tags";
import { environment } from "../../../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class InsertionService {

  apiEndPoint: string;
  constructor(private http: HttpClient) {
    const proxy = environment.proxy_ip;
    console.log('Proxy IP:', proxy);
    this.apiEndPoint = "/api/v1/insertion"
  }

  saveInsertion(ins: insertion) {
    console.log('saveInsertion request');
    return this.http.post(this.apiEndPoint, ins);
  }

  deleteInsertion(id: number) {
    console.log('deleteInsertion request: id='+id);
    return this.http.delete(this.apiEndPoint+'/'+id);
  }

  updateInsertion(id: number, ins: insertion): any {
    console.log('updateInsertion request: id='+id);
    return this.http.put(this.apiEndPoint+'/'+id, ins);
  }

  fetchInsertionList(): any {
    console.log('fetchInsertionList request');
    return this.http.get(this.apiEndPoint);
  }

  findInsertion(id: number): any {
    console.log('findInsertion request: id='+id);
    return this.http.get(this.apiEndPoint+'/'+id);
  }

}
