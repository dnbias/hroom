import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import {AuthService} from '../../service/auth.service'
import { ToastrService } from 'ngx-toastr'
import { registrationRequest } from '../../shared/models/registrationRequest';
import {UserService} from "../../service/user/user.service";
import {SignUpRequest} from "../../shared/models/signUpRequest";

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.css']
})




export class RegistrazioneComponent implements OnInit {
  registerForm: FormGroup;

  constructor(private fb: FormBuilder, private userService: UserService,private router: Router) {
    this.registerForm = this.fb.group({
      username: ['', Validators.required],
      telefono: ['', Validators.required],
      cognome: ['', Validators.required],
      name: ['', Validators.required],
      password: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      role: ['', Validators.required]
    });
  }

  ngOnInit(): void {}

  proceedRegister() {
    if (this.registerForm.valid) {
      const user: SignUpRequest = {
        username: this.registerForm.value.username,
        phoneNumber: this.registerForm.value.telefono,
        surname: this.registerForm.value.cognome,
        name: this.registerForm.value.name,
        password: this.registerForm.value.password,
        email: this.registerForm.value.email,
        provider: '', // Puoi settarlo se necessario
        role: this.registerForm.value.role
      };

      this.userService.saveUser(user).subscribe(
        response => {
          console.log('User saved successfully', response);
          this.router.navigate(['']);
        },
        error => {
          console.error('Error saving user', error);
        }
      );
    } else {
      console.error('Form is invalid');
    }
  }
}

