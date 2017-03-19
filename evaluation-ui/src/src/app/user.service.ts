import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class UserService {
    private loggedIn = false;

    constructor(private http: Http) {
        this.loggedIn = !!localStorage.getItem('auth_token');
    }

    login(username, password) {
        let headers = new Headers();
        headers.append('Content-Type', 'application/json');
        return this.http
            .post(
                'http://localhost:9001/auth/login',
                JSON.stringify({ username, password }),
                { headers }
            )
            .map(res => res.json())
            .map((res) => {
                    localStorage.setItem('auth_token', res.auth_token);
                    this.loggedIn = true;
                return res;
            });
    }

    logout() {
        localStorage.removeItem('auth_token');
        this.loggedIn = false;
    }

    isLoggedIn() {
        return this.loggedIn;
    }
}