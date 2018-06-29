import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginFormComponent } from './forms/login-form/login-form.component';
import { SignupFormComponent } from './forms/signup-form/signup-form.component';
import { NewRequestFormComponent } from './forms/new-request-form/new-request-form.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { UserPageComponent } from './pages/user-page/user-page.component';
import { WorkerPageComponent } from './pages/worker-page/worker-page.component';
import { NotfoundPageComponent } from './pages/notfound-page/notfound-page.component';
import { SettingsPageComponent } from './pages/settings-page/settings-page.component';
import { ChangePasswordFormComponent } from './forms/change-password-form/change-password-form.component';
import { AuthService } from './services/auth.service';

/* 
  TODO: spostare <routes> in un modulo separato ed importarlo in app.module.ts
*/
const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'login', component: LoginFormComponent},
  {path: 'signup', component: SignupFormComponent},
  {path: 'settings', component: SettingsPageComponent},
  {path: 'user', component: UserPageComponent},
  {path: '**', component: NotfoundPageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginFormComponent,
    SignupFormComponent,
    SettingsPageComponent,
    NewRequestFormComponent,
    HomePageComponent,
    UserPageComponent,
    WorkerPageComponent,
    NotfoundPageComponent,
    ChangePasswordFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes, {useHash: true})
  ],
  providers: [AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
