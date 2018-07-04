import {Component, Inject, OnInit} from '@angular/core';
import {Fornitore} from "../../interfaces/fornitore";
import {TakeFornintoriService} from "../../services/take-fornintori.service";
import {User, UserType} from "../../interfaces/user";

@Component({
  selector: 'app-profile-page',
  templateUrl: './profile-page.component.html',
  styleUrls: ['./profile-page.component.css']
})
export class ProfilePageComponent implements OnInit {

  user: User;
  fornitori: Fornitore[];

  constructor(private serv: TakeFornintoriService) {
  }

  ngOnInit() {
    this.user.email = localStorage.getItem("email");
    if (localStorage.getItem("tipo") == UserType.Guest)
      this.user.type = UserType.Guest;
    else if (localStorage.getItem("tipo") == UserType.Vendor)
      this.user.type = UserType.Vendor;
    else
      this.user.type = UserType.Client;
    this.user.nome = localStorage.getItem("nome");


    this.serv.getFornitori().subscribe((list: Fornitore[]) => {
      this.fornitori = list;
    }, (error) => {
      console.log(error.toString());
    });
  }

}
