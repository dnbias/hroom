import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { insertion } from "../../shared/models/insertion";
import { Tag } from "../../shared/models/tags";

@Injectable({
  providedIn: 'root'
})
export class InsertionService {


  apiEndPoint:  string;
  constructor(private http: HttpClient) {
    this.apiEndPoint = "/api/v1"
  }

  saveInsertion(ins: any[]) {
    console.log('saveInsertion request');
    return this.http.post(this.apiEndPoint+'/insertion', ins);
  }

  deleteInsertion(id: number) {
    console.log('deleteInsertion request: id='+id);
    return this.http.delete(this.apiEndPoint+'/insertion/'+id);
  }

  updateInsertion(id: number, ins: insertion): any {
    console.log('updateInsertion request: id='+id);
    return this.http.put(this.apiEndPoint+'/insertion/'+id, ins);
  }

  fetchInsertionList(): any {
    console.log('fetchInsertionList request');
    return this.http.get(this.apiEndPoint+'/insertion');
  }

  findInsertion(id: number): any {
    console.log('findInsertion request: id='+id);
    return this.http.get(this.apiEndPoint+'/insertion/'+id);
  }
/*
  uploadPhoto(data: any): any {
    console.log('uploadPhoto request');
    return this.http.put(this.apiEndPoint+'/insertion/photo', {
      responseType: 'string', // the URI
      data: data
    });
  }*/
  uploadPhoto(file: any): any {
    const formData: FormData = new FormData();
    formData.append('file', file);
    console.log('uploadPhoto request');
    return this.http.put(this.apiEndPoint + '/insertion/photo', formData, {
      responseType: 'text' // Expecting a string response (token/URI)
    });
  }

  downloadPhoto(id: any): any {
    console.log('downloadPhoto request');
    return this.http.get(this.apiEndPoint+'/insertion/photo/'+id, {
      responseType: 'blob'
    });
  }

  deletePhoto(id: any): any {
    console.log('downloadPhoto request');
    return this.http.delete(this.apiEndPoint+'/insertion/photo/'+id);
  }

  getAllTags(): string[] {
    return Object.keys(Tag);
  }

}

