import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from './user.service';
import {FormBuilder, Validators} from '@angular/forms';

@Component({
    selector: 'login',
    template: `<form [formGroup]="loginForm" (ngSubmit)="onSubmit($event)">
    <input formControlName="name" type="text" placeholder="Your Username">
    <input formControlName="password" type="password" placeholder="Your password">
  <button type="submit">Log in</button>
</form>`
})
export class LoginComponent {
    constructor(private fb: FormBuilder, private userService: UserService, private router: Router) {}

    public loginForm = this.fb.group({
        name: ["", Validators.required],
        password: ["", Validators.required]
    });

    onSubmit(form) {
        console.log("test", this.loginForm.value.name, this.loginForm.value.password);
        this.userService.login(this.loginForm.value.name, this.loginForm.value.password).subscribe((result) => {
            if (result) {
                this.router.navigate(['profile']);
            }
        });
    }
}