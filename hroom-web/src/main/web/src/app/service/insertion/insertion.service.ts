import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import dotenv from 'dotenv';

@Injectable({
  providedIn: 'root'
})
export class InsertionService {

  apiEndPoint: string;
  constructor(private http: HttpClient) {
    dotenv.config();  // Load environment variables from .env file
    const proxy = process.env['PROXY_IP'];
    console.log('Proxy IP:', proxy);
    this.apiEndPoint = proxy+"/api/v1/insertion"
  }

  saveInsertion(ins: insertion) {
    console.log('saveInsertion request');
    return this.http.post(this.apiEndPoint, ins);
  }

  deleteInsertion(id: number) {
    console.log('deleteInsertion request: id='+id);
    return this.http.delete(this.apiEndPoint+'/'+id);
  }

  updateInsertion(id: number, ins: insertion) {
    console.log('updateInsertion request: id='+id);
    return this.http.put(this.apiEndPoint+'/'+id, ins);
  }

  fetchInsertionList() {
    console.log('fetchInsertionList request');
    return this.http.get(this.apiEndPoint);
  }

  findInsertion(id: number) {
    console.log('findInsertion request: id='+id);
    return this.http.get(this.apiEndPoint+'/'+id);
  }

}
