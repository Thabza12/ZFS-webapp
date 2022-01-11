import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user = new User();
  msg = '';

  constructor(private _service : RegistrationService,
              private _router : Router) { }

  ngOnInit(): void {
  }

  signupUser(){
    this._service.registerUser(this.user).subscribe(
      data => {
        console.log("response recieved");
        this.msg="Registration successful";
      },
      error => {
        console.log("exception occured");
        this.msg=error.error;
      }
    )
  }

  login(){
    this._router.navigate([''])
  }

}
