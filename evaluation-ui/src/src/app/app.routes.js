"use strict";
var home_component_1 = require('./home/home.component');
var login_component_1 = require('./login.component');
var profile_component_1 = require('./profile/profile.component');
var logged_in_guard_1 = require('./logged-in.guard');
exports.routes = [
    { path: '', component: home_component_1.HomeComponent, pathMatch: 'full' },
    { path: 'login', component: login_component_1.LoginComponent },
    { path: 'profile', component: profile_component_1.ProfileComponent, canActivate: [logged_in_guard_1.LoggedInGuard] }
];
