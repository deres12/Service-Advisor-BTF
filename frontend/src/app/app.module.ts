import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { StorageServiceModule} from 'angular-webstorage-service';
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
import { ChisiamoComponent } from './pages/chisiamo/chisiamo.component';
import { ProfilePageComponent } from './pages/profile-page/profile-page.component';
import { ListaFornitoriComponent } from './lista-fornitori/lista-fornitori.component';
import { TestDataService } from './mock-data/test-data.service';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './footer/footer.component';
import { CardsFornitoriComponent } from './cards-fornitori/cards-fornitori.component';
import { MappaComponent } from './components/mappa/mappa.component';
import { NgxStripeModule } from 'ngx-stripe';
import { PaymentsComponent } from './components/payments/payments.component';
import { HttpModule } from "@angular/http";
import { TestMappaComponent } from './mock-data/test-mappa/test-mappa.component';
import { SearchVendorComponent } from './search-vendor/search-vendor.component';
import { MappaAGMComponent } from './components/mappa-agm/mappa-agm.component';
import { AgmCoreModule } from '@agm/core';
import { AgmSnazzyInfoWindowModule } from '@agm/snazzy-info-window';
import {} from '@types/googlemaps';

/*
  TODO: spostare <routes> in un modulo separato ed importarlo in app.module.ts
*/
const routes: Routes = [
  {path: 'testMapp', component: TestMappaComponent},
  {path: 'profile', component: ProfilePageComponent},
  {path: 'about', component: ChisiamoComponent},
  {path: 'signup', component: SignupPageComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'new-request', component: NewRequestFormComponent},
  {path: 'search', component: SearchVendorComponent},
  {path: 'settings', component: SettingsPageComponent},
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
    ChisiamoComponent,
    ProfilePageComponent,
    ListaFornitoriComponent,
    FooterComponent,
    CardsFornitoriComponent,
    MappaComponent,
    TestMappaComponent,
    PaymentsComponent,
    SearchVendorComponent,
    MappaAGMComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    HttpClientModule,
    HttpModule,
    FormsModule,
    StorageServiceModule,
    NgbModule.forRoot(),
    NgxStripeModule.forRoot('pk_test_telEqsWJwaOuBQXVfwFR3u9q'),
    RouterModule.forRoot(routes, {useHash: true}),
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyCO86P-aWvq0wCdj6rSwVYF7jdbqAV3F4s'
    }),
    AgmSnazzyInfoWindowModule
  ],
  providers: [AuthService, TestDataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
