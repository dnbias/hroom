import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {AuthService} from '../../service/auth.service'
import { ToastrService } from 'ngx-toastr'
import { registrationRequest } from '../../shared/models/registrationRequest';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.css']
})
export class RegistrazioneComponent implements OnInit {

  constructor(private builder: FormBuilder, private service: AuthService, private router: Router,
              private toastr: ToastrService) {

  }

  request: registrationRequest = new registrationRequest();

  registerform = this.builder.group({
    id: this.builder.control('', Validators.compose([Validators.required, Validators.minLength(5)])),
    name: this.builder.control('', Validators.required),
    password: this.builder.control('', Validators.compose([
      Validators.required,
      Validators.minLength(8)])),
    email: this.builder.control('', Validators.compose([
      Validators.required, Validators.email])),
    gender: this.builder.control('male'),
    role: this.builder.control(''),
    isactive: this.builder.control(false)
  });

  proceedRegister() {
    if (this.registerform.valid) {
      this.request.username = this.id;
      this.request.name = this.name;
      this.request.surname = 'Pippo';
      this.request.role = 'tenant';
      this.request.phoneNumber = '3339871212';
      this.request.password = this.password;
      this.request.email = this.email;
      console.log(this.request);
      this.service.registerUser(this.request).subscribe(result => {
        console.log(result);
        this.toastr.success('Registered successfully')
        this.router.navigate(['login'])
      });
    } else {
      this.toastr.warning('Please enter valid data.')
    }
  }

  ngOnInit(): void {
  }

  get id() { return this.registerform.value?.id; }

  get name() { return this.registerform.value?.name; }

  get password() { return this.registerform.value?.password; }

  get email() { return this.registerform.value?.password; }

}
