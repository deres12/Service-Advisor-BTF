import { Component } from '@angular/core';
import { AuthService, UserType } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  userType = UserType;

  constructor(public auth: AuthService) {}
}
