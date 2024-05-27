
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

  ngOnInit() {
    // @ts-ignore
    google.accounts.id.initialize({
      client_id: "55986931159-cgo7iq0rkupitd85injpre9bg69oh199.apps.googleusercontent.com",
      callback: this.handleCredentialResponse.bind(this),
      auto_select: false,
      cancel_on_tap_outside: true,

    });
    // @ts-ignore
    google.accounts.id.renderButton(
      // @ts-ignore
      document.getElementById("google-button"),
      { theme: "outline", size: "large", width: "100%" }
    );
    // @ts-ignore
    google.accounts.id.prompt((notification: PromptMomentNotification) => {});
  }

  async handleCredentialResponse(response: any) {
    // Here will be the response from Google.
    // console.log(response);
    this.loginGoogle();
    this.toastr.success('OK', 'Active User');
    this.router.navigate(['home']);
  }

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
          sessionStorage.setItem('id',this.result.id);
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

  loginGoogle() {
    sessionStorage.setItem('id', '1');
    sessionStorage.setItem('username', 'dnbias');
    sessionStorage.setItem('role', 'tenant');
  }

  get id() { return this.loginform.value?.id; }

  get password() { return this.loginform.value?.password; }


}
