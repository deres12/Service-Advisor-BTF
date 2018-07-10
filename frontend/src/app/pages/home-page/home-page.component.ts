import {Component, OnInit} from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { UserType } from '../../models/user';
import { Router } from '@angular/router';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  userType = UserType;

  constructor(
    public auth: AuthService,
    public router: Router
  ) {}

  ngOnInit() {

  }

  searchByText(query: string) {
    this.router.navigate(["/search"], {queryParams: {q: query}});
  }
}
