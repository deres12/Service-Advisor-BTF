import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { SideMenuComponent } from './side-menu/side-menu.component';
import { DialogContainerComponent } from './dialog-container/dialog-container.component';
import { ContentViewComponent } from './content-view/content-view.component';
import { LoginFormComponent } from './forms/login-form/login-form.component';
import { SignupFormComponent } from './forms/signup-form/signup-form.component';
import { NewRequestFormComponent } from './forms/new-request-form/new-request-form.component';
import { ModalComponent } from './modal/modal.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    SideMenuComponent,
    DialogContainerComponent,
    ContentViewComponent,
    LoginFormComponent,
    SignupFormComponent,
    NewRequestFormComponent,
    ModalComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
