
import {Component, OnInit} from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr'
import { AuthService } from '../../service/auth.service';
import { loginRequest } from '../../shared/models/loginRequest';


// /*per l'avvio json-server --watch db.json
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],

})

export class LoginComponent {
  constructor(private builder: FormBuilder, private toastr: ToastrService,
              private service: AuthService, private router: Router) {
    sessionStorage.clear();
  }

  result: any;
  request: loginRequest = new loginRequest();

  loginform = this.builder.group({
    id: this.builder.control('', Validators.required),
    password: this.builder.control('', Validators.required)
  });

  proceedLogin() {
    // console.log('Login test')
    // req = new loginRequest();
    // req.username = 'admin'
    // req.username = 'admin'

    // this.service.login(this.request).subscribe(res => {
    //   console.log(res);
    // });
    console.log('proceedLogin call');
    if (this.loginform.valid) {
      this.request.username = this.id;
      this.request.password = this.password;
      this.service.login(this.request).subscribe(res => {
        this.result = res;
        console.log(this.result);
        if (this.result.password === this.request.password) {
          sessionStorage.setItem('username',this.request.username);
          sessionStorage.setItem('role',this.result.role);
          this.toastr.success('OK', 'Active User');
          this.router.navigate(['home']);
        } else {
          this.toastr.error('Invalid credentials');
        }
      });
    } else {
      this.toastr.warning('Please enter valid data.');
    }
  }

  get id() { return this.loginform.value?.id; }

  get password() { return this.loginform.value?.password; }

}
