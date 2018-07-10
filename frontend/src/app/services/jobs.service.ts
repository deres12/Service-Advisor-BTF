import { Injectable } from '@angular/core';
import { Job, JobService } from '../models/job';


@Injectable({
  providedIn: 'root'
})
export class JobsDataService {

  private jobs: Job[] = [
    {
      id: 1,
      nome: "Elettricista",
      icon: "/assets/res/electric1.png",
      servizi: [
        {id: 1, descrizione: "sostituzione lampadina"},
        {id: 2, descrizione: "sostituzione batterie"}
      ]
    },
    {
      id: 2,
      nome: "Idraulico",
      icon: "/assets/res/pipe1.png",
      servizi: [
        {id: 3, descrizione: "sostituire tubature"},
        {id: 4, descrizione: "sturare il lavandino"}
      ]
    },
    {
      id: 3,
      nome: "Gommista",
      icon: "/assets/res/tire.png",
      servizi: [
        {id: 5, descrizione: "sgomma"}
      ]
    }
  ];

  constructor() { }

  getAll(): Job[] {
    return this.jobs;
  }

  getById(id: number) {
    for(let job of this.jobs) {
      if(job.id == id) {
        return job;
      }
    }
    return null;
  }

  getServicesByJob(id: number): JobService[]  {
    return this.jobs[id].servizi;
  }
}
