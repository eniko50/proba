import { Component, OnInit, ViewEncapsulation } from '@angular/core';

import { AuthenticationService } from '../security/authentication.service'
import { Observable } from 'rxjs';

import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {

  public user;

  public wrongUsernameOrPass:boolean;

  constructor(private authenticationService:AuthenticationService,
              private router: Router) {
    this.user = {};
    this.wrongUsernameOrPass = false;
   }

  ngOnInit() {
  }

  login():void{
    this.authenticationService.login(this.user.username, this.user.password).subscribe(
      (loggedIn:boolean) => {
        if(loggedIn && this.user.username === "admin"){
          this.router.navigate(['/mainAdmin']);          
        } else {
          this.router.navigate(['/main']);
        }
      }
    );
  }

}
