import { Component, OnInit } from '@angular/core';
import { JobsDataService } from '../../services/jobs.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-new-request-form',
  templateUrl: './new-request-form.component.html',
  styleUrls: ['./new-request-form.component.css']
})
export class NewRequestFormComponent implements OnInit {

  constructor(private jobs: JobsDataService) { }

  ngOnInit() {}

  valid(form: NgForm): boolean {
    return false;
  }

  submit(form: NgForm) {
    if(!this.valid(form)) return;
    
    // call REST API
  }
}
