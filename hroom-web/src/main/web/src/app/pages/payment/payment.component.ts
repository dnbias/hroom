import { Component } from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MatButton} from "@angular/material/button";
import {MatError, MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatRadioButton, MatRadioGroup} from "@angular/material/radio";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-payment',

  templateUrl: './payment.component.html',
  styleUrl: './payment.component.css'
})
export class PaymentComponent {
  paymentForm: FormGroup;
  selectedPaymentMethod: 'paypal' | 'creditCard' = 'paypal'; // Default method is PayPal

  constructor(private formBuilder: FormBuilder) {
    this.paymentForm = this.formBuilder.group({
      cardNumber: ['', [Validators.required, Validators.pattern(/^\d{16}$/)]],
      expirationDate: ['', [Validators.required, Validators.pattern(/^(0[1-9]|1[0-2])\/\d{2}$/)]],
      cvv: ['', [Validators.required, Validators.pattern(/^\d{3}$/)]]
    });
  }

  onSubmit() {
    if (this.paymentForm.valid) {
      // Logica per l'invio dei dati del pagamento
      console.log('Payment details submitted:', this.paymentForm.value);
    } else if(this.paymentForm) {
      // Form non valido, mostra eventuali errori
      console.log('Payment form invalid');
    }
  }
  redirectToPayPal() {
    // Simulazione del redirect a PayPal (sostituisci l'URL con quello corretto di PayPal)
    window.location.href = 'https://www.paypal.com'; // Cambia l'URL con quello corretto di PayPal
  }

}
