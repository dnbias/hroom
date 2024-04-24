import {Component, inject} from '@angular/core';
import { CommonModule } from '@angular/common';
declare var google: any;
import { AuthappService } from '../../../services/authapp.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Observable,map, of} from "rxjs";
@Component({
    selector: 'app-loggoogle',
  templateUrl: './loggoogle.component.html',
  styleUrl: './loggoogle.component.css'
})
export class LoggoogleComponent {
    userId: string = "";
    password: string = "";

    autenticato: boolean = true;
    filter$: Observable<string | null> = of("");
    notlogged : boolean = false;


    errMsg: string = "Spiacente, la userid e/o la password sono errati!";
    errMsg2: string = "Spiacente, devi autenticarti per poter accedere alla pagina selezionata!";

    titolo: string = "Accesso & Autenticazione";
    sottotitolo: string = "Procedi ad inserire la userid e la password";

    constructor(private route: Router, private route2: ActivatedRoute, private BasicAuth: AuthappService ) { }

    private router = inject(Router);
    ngOnInit(): void {
        google.accounts.id.initialize({
            client_id: '805273237589-dqg9c3gk6245vuk9qe62j6uoef0i4fa3.apps.googleusercontent.com',
            callback: (resp: any )=>this.handleLogin(resp)


        });
        google.accounts.id.renderButton(document.getElementById("google-btn"),{
            theme: 'filled-blue',
            size:'large',
            shape:'rectangle',
            width: 350,

        })



        this.filter$ = this.route2.queryParamMap.pipe
        (
            map((params: ParamMap) => params.get('nologged')),
        );

        this.filter$.subscribe((param: any) => (param) ? this.notlogged = true : this.notlogged = false);

        console.log(this.notlogged);

    }

    gestAuth = (): void => {
        console.log(this.userId);

        if (this.BasicAuth.autentica(this.userId, this.password)) {
            this.route.navigate(['welcome', this.userId]);

            this.autenticato = true;
        }
        else {
            this.autenticato = false;

        }
    }


    private decodeToken(token: string){
        return JSON.parse(atob(token.split(".")[1]));
    }
    handleLogin(response: any){
        if(response){
            //decode the token
            const payload = this.decodeToken((response.credential))
            //store in session
            sessionStorage.setItem("loggedInUser",JSON.stringify(payload));
            //navigate to home
            this.router.navigate(['home'])

        }
    }
}
