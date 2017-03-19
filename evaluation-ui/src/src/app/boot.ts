import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserService } from './user.service';
import { LoggedInGuard } from './logged-in.guard';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login.component';
import { ProfileComponent } from './profile/profile.component';
import { routes } from './app.routes';

@NgModule({
    bootstrap: [AppComponent],
    declarations: [AppComponent, HomeComponent, LoginComponent, ProfileComponent],
    imports: [
        BrowserModule,
        HttpModule,
        FormsModule,
        ReactiveFormsModule,
        RouterModule.forRoot(routes)
    ],
    providers: [UserService, LoggedInGuard]
})
export class BootModule {}