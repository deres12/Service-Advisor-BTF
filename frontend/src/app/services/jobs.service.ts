import { Injectable } from '@angular/core';

export interface JobService {
  id: number,
  descrizione: string
}

export interface Job {
  id: number,
  nome: string,
  servizi: JobService[]
}

@Injectable({
  providedIn: 'root'
})
export class JobsService {

  private jobs: Job[] = [
    {
      id: 1,
      nome: "Elettricista",
      servizi: [
        {id: 1, descrizione: "sostituzione lampadina"},
        {id: 2, descrizione: "sostituzione batterie"}
      ]
    },
    {
      id: 2,
      nome: "Idraulico",
      servizi: [
        {id: 3, descrizione: "sostituire tubature"},
        {id: 4, descrizione: "sturare il lavandino"}
      ]
    },
    {
      id: 3,
      nome: "Gommista",
      servizi: [
        {id: 5, descrizione: "sgomma"}
      ]
    }
  ];

  constructor() { }

  getAll(): Job[] {
    return this.jobs;
  }

  getServicesByJob(id: number): JobService[]  {
    return this.jobs[id].servizi;

  }
}
