import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from './user.service';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
    selector: 'login',
    templateUrl: 'login.html'
})
export class LoginComponent {
    _username : string;
    _password : string;

    constructor(private userService: UserService, private router: Router) {}

    login(username : string, password : string){

        this._username = username;
        this._password = password; 
        this.userService.login(this._username, this._password).subscribe((result) => {
            if (result) {
                this.router.navigate(['profile']);
            }
        });
    }
}