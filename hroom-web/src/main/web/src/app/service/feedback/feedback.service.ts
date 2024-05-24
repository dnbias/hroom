import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from "../../../environment/environment";
import { feedback } from '../../shared/models/feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  apiEndPoint: string;
  constructor(private http: HttpClient) {
    const proxy = environment.proxy_ip;
    this.apiEndPoint = "/api/v1/feedback"
  }

  saveFeedback(fb: feedback) {
    console.log('saveFeedback request');
    return this.http.post(this.apiEndPoint, fb);
  }

  deleteFeedback(id: number) {
    console.log('deleteFeedback request');
    return this.http.delete(this.apiEndPoint+'/'+id);
  }

  updateFeedback(id: number, fb: feedback) {
    console.log('updateFeedback request');
    return this.http.put(this.apiEndPoint+'/'+id, fb);
  }

  fetchFeedbackList() {
    console.log('fetchFeedbackList request');
    return this.http.get(this.apiEndPoint);
  }

  findFeedback(id: number) {
    console.log('findFeedback request');
    return this.http.get(this.apiEndPoint+'/'+id);
  }

}
