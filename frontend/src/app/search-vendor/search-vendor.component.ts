import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Fornitore } from '../models/fornitore';
import { TakeFornintoriService } from '../services/take-fornintori.service';
import { JobsDataService } from '../services/jobs.service';

@Component({
  selector: 'app-search-vendor',
  templateUrl: './search-vendor.component.html',
  styleUrls: ['./search-vendor.component.css']
})
export class SearchVendorComponent implements OnInit {

  fornitori: Fornitore[];
  showFornit: Fornitore[];

  searchQuery: string = ""

  noResult: boolean = false;

  constructor(
    public route: ActivatedRoute,
    public routing: Router,
    public serv: TakeFornintoriService,
    public jobsData: JobsDataService
  ) {}

  ngOnInit() {
    this.route.queryParams.subscribe(
      params => {
        this.searchQuery = params["q"] || "";
      }
    );

    this.serv.getFornitori().subscribe(
      (list: Fornitore[]) => {
        console.log(list);
        this.fornitori = list;
        this.showFornit = list;
        if(this.searchQuery.trim().length > 0) {
          this.searchByText();
        }
      },
      error => {
        console.error(error);
        this.noResult = true;
      }
    );
  }

  searchByText() {
    this.routing.navigate([], {queryParams: {q: this.searchQuery}});
    
    var regexes = this.searchQuery.trim().split(/ +/).map(word => new RegExp(word, "i"));
      
    this.showFornit = this.fornitori.filter(forn => {
      const job = this.jobsData.getById(forn.professione);
      const address = forn.via.paese+" "+forn.via.via;
      for(let re of regexes) {
        if(re.test(job.nome) /*|| re.test(forn.descrizione)*/ || re.test(forn.nome) || re.test(address)) {
          return true;
        }
      }
      return false;
    });

    this.noResult = (this.showFornit.length == 0);
  }

  searchByArea() {
    // ...
  }
}
