import { Injectable } from '@angular/core';

interface Job {
  id: number,
  name: string
}

@Injectable({
  providedIn: 'root'
})
export class JobsService {
  
  private jobs: Job[] = [
    {id: 1, name: "Elettricista"},
    {id: 2, name: "Idraulico"},
    {id: 3, name: "Gommista"}
  ];

  constructor() { }

  getAll(): Job[] {
    return this.jobs;
  }
}
