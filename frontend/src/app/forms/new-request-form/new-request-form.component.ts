import { Component, OnInit } from '@angular/core';
import { JobsService } from '../../services/jobs.service';

@Component({
  selector: 'app-new-request-form',
  templateUrl: './new-request-form.component.html',
  styleUrls: ['./new-request-form.component.css']
})
export class NewRequestFormComponent implements OnInit {

  constructor(private jobs: JobsService) { }

  ngOnInit() {
  }

  validate(): boolean {
    return false;
  }

  submit(event) {
    event.preventDefault();
    if(!this.validate()) return;
    // call REST API
  }
}
