import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginFormComponent } from './forms/login-form/login-form.component';
import { NewRequestFormComponent } from './forms/new-request-form/new-request-form.component';
import { HomePageComponent } from './pages/home-page/home-page.component';
import { UserPageComponent } from './pages/user-page/user-page.component';
import { WorkerPageComponent } from './pages/worker-page/worker-page.component';
import { NotfoundPageComponent } from './pages/notfound-page/notfound-page.component';
import { SettingsPageComponent } from './pages/settings-page/settings-page.component';
import { ChangePasswordFormComponent } from './forms/change-password-form/change-password-form.component';
import { AuthService } from './services/auth.service';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { SignupPageComponent } from './pages/signup-page/signup-page.component';
import { RichiestePageComponent } from './pages/richieste-page/richieste-page.component';
import { ChisiamoComponent } from './pages/chisiamo/chisiamo.component';
import { ProfilePageComponent } from './pages/profile-page/profile-page.component';

/*
  TODO: spostare <routes> in un modulo separato ed importarlo in app.module.ts
*/
const routes: Routes = [
  {path: 'profile', component: ProfilePageComponent},
  {path: 'about', component: ChisiamoComponent},
  {path: 'signup', component: SignupPageComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'user', component: UserPageComponent},
  {path: 'settings', component: SettingsPageComponent},
  {path: 'richieste', component: RichiestePageComponent},
  {path: '', component: HomePageComponent},
  {path: '**', component: NotfoundPageComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginFormComponent,
    SettingsPageComponent,
    NewRequestFormComponent,
    HomePageComponent,
    UserPageComponent,
    WorkerPageComponent,
    NotfoundPageComponent,
    ChangePasswordFormComponent,
    LoginPageComponent,
    SignupPageComponent,
    RichiestePageComponent,
    ChisiamoComponent,
    ProfilePageComponent
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
