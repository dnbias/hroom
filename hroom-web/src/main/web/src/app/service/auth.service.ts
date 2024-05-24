import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from "../../environment/environment";
import { loginRequest } from '../shared/models/loginRequest';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiEndPoint: string;

  constructor(private http:HttpClient) {
    const proxy = environment.proxy_ip;
    this.apiEndPoint='/api/v1/';
  }

  login(inputdata: loginRequest){
    console.log('login request');
    return this.http.post(this.apiEndPoint+'login',inputdata)
  }
  registerUser(inputdata:any){
    return this.http.post(this.apiEndPoint+'signup',inputdata,
                                  { responseType: 'text' });
  }
  getUser(username:any){
    return this.http.get(this.apiEndPoint+'user/'+username);
  }
  getAll(){
    return this.http.get(this.apiEndPoint+'user');
  }
  updateUser(id:any,inputdata:any){
    return this.http.put(this.apiEndPoint+'user/'+id, inputdata);
  }
  getUserRole(){
    return this.http.get(this.apiEndPoint+'role');
  }
  getUserInfo(){
    return this.http.get(this.apiEndPoint+'info');
  }
  isLoggedIn(){
    return sessionStorage.getItem('username')!=null;
  }
  getRole(){
    return sessionStorage.getItem('role')!=null?sessionStorage.getItem('role')?.toString():'';
  }
  // getAllCustomer(){
  //   return this.http.get(this.apiEndPoint+/'user');
  // }
  getAccessByRole(role:any,menu:any){
    return this.http.get('http://localhost:3000/roleaccess?role='+role+'&menu='+menu)
  }


  loggedUser = (): string | null => (sessionStorage.getItem('username'));

  isLogged = (): boolean => (sessionStorage.getItem('username')) ? true : false;

  clearUser = (): void => sessionStorage.removeItem('username');

  clearAll = (): void => sessionStorage.clear();
}
