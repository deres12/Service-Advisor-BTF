import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';
import { UserType } from './interfaces/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  userType = UserType;


  constructor(public auth: AuthService) {}
}
